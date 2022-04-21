package com.abdsoft.med_dose.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.abdsoft.med_dose.ui.dashboard.HistoryItem
import com.abdsoft.med_dose.ui.home.HomeItem
import org.json.JSONException
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class DatabaseHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {
        val query = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL, " +
                    "%s INTEGER NOT NULL, " +
                    "%s INTEGER NOT NULL, " +
                    "%s INTEGER NOT NULL, " +
                    "%s INTEGER NOT NULL, " +
                    "%s INTEGER NOT NULL, " +
                    "%s TEXT NOT NULL, " +
                    "%s TEXT NOT NULL);",
            DB_TABLE,
            KEY_ID,
            KEY_NAME,
            KEY_DAY,
            KEY_MONTH,
            KEY_YEAR,
            KEY_TIMES_PER_DAY,
            KEY_TOTAL_DOSES,
            KEY_TIMINGS,
            KEY_ALERT_TYPE
        )
        if (sqLiteDatabase != null) {
            sqLiteDatabase.execSQL(query)
        }
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, i: Int, i1: Int) {
        val queryUpgrade = String.format("DELETE TABLE IF EXISTS %s", DB_TABLE)
        if (sqLiteDatabase != null) {
            sqLiteDatabase.execSQL(queryUpgrade)
        }
        onCreate(sqLiteDatabase)
    }

    fun insertNewMedicine(
        medicineName: String?,
        day: Int,
        month: Int,
        year: Int,
        noOfTimesPerDay: Int,
        totalDoses: Int,
        timings: String?,
        alertType: String?
    ) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, medicineName)
        values.put(KEY_DAY, day)
        values.put(KEY_MONTH, month)
        values.put(KEY_YEAR, year)
        values.put(KEY_TIMES_PER_DAY, noOfTimesPerDay)
        values.put(KEY_TOTAL_DOSES, totalDoses)
        values.put(KEY_TIMINGS, timings)
        values.put(KEY_ALERT_TYPE, alertType)
        db.insertWithOnConflict(DB_TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE)
        Log.i(
            "Med-Dose DB Helper",
            medicineName + day + month + year + noOfTimesPerDay + totalDoses + timings + alertType
        )
        db.close()
    }

    fun deleteMedicine(medicineName: String?) {
        val db = this.writableDatabase
        db.delete(DB_TABLE, KEY_NAME + " = ?", arrayOf(medicineName))
        db.close()
    }

    fun getMedicineList(): MutableList<HomeItem?>? {
        val medicineList: MutableList<HomeItem?> = ArrayList()
        val db = this.readableDatabase
        val cursor =
            db.query(DB_TABLE, arrayOf(KEY_NAME, KEY_TIMES_PER_DAY), null, null, null, null, null)
        while (cursor.moveToNext()) {
            val homeItem = HomeItem(cursor.getString(0), cursor.getString(1) + " times a day")
            medicineList.add(homeItem)
        }
        cursor.close()
        db.close()
        return medicineList
        /* JSONObject json = new JSONObject(stringreadfromsqlite);
        ArrayList items = json.optJSONArray("uniqueArrays");*/
    }

    fun getId(name: String?): Int {
        var id = 0
        val db = this.writableDatabase
        val cursor =
            db.query(DB_TABLE, arrayOf(KEY_NAME, KEY_TIMES_PER_DAY), null, null, null, null, null)
        while (cursor.moveToNext()) {
            id = cursor.getInt(0)
        }
        cursor.close()
        db.close()
        return id
    }

    fun getMedicineHistory(): MutableList<HistoryItem?>? {
        val historyList: MutableList<HistoryItem?> = ArrayList()
        val db = this.readableDatabase
        val cursor = db.query(
            DB_TABLE,
            arrayOf(
                KEY_NAME,
                KEY_DAY,
                KEY_MONTH,
                KEY_YEAR,
                KEY_TIMES_PER_DAY,
                KEY_TOTAL_DOSES,
                KEY_TIMINGS
            ),
            null,
            null,
            null,
            null,
            null
        )
        while (cursor.moveToNext()) {
            val calendar = Calendar.getInstance()
            calendar[cursor.getInt(3), cursor.getInt(2)] = cursor.getInt(1)
            val format1 = SimpleDateFormat("EEEE, MMMM d, yyyy")
            val date = format1.format(calendar.time)
            val historyItem = HistoryItem(
                cursor.getString(0),
                date,
                cursor.getInt(4),
                cursor.getInt(5),
                cursor.getString(6)
            )
            historyList.add(historyItem)
        }
        cursor.close()
        db.close()
        return historyList
    }

    fun getTimings(medicineName: String?): MutableList<String?>? {
        val timingList: MutableList<String?> = ArrayList()
        val timingsString = StringBuffer()
        val db = this.readableDatabase
        val cursor = db.query(
            DB_TABLE,
            arrayOf(KEY_TIMINGS),
            KEY_NAME + " = ?",
            arrayOf(medicineName),
            null,
            null,
            null
        )
        while (cursor.moveToNext()) {
            timingsString.append(cursor.getString(0))
            Log.i("Timings", timingsString.toString())
        }
        var json: JSONObject? = null
        try {
            json = JSONObject(String(timingsString))
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        val items = json!!.optJSONArray("timingArrays")
        for (i in 0 until items.length()) {
            try {
                timingList.add(items.getString(i))
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        return timingList
    }

    fun noOfDaysLeft(medicineName: String?, mNextAlarmDate: Calendar?): Int {
        var mPerDay = 0
        var mTotalDodes = 0
        var day = 0
        var month = 0
        var year = 0
        val db = this.readableDatabase
        val cursor = db.query(
            DB_TABLE,
            arrayOf(
                KEY_DAY,
                KEY_MONTH,
                KEY_YEAR,
                KEY_TIMES_PER_DAY,
                KEY_TOTAL_DOSES
            ),
            KEY_NAME + " = ?",
            arrayOf(medicineName),
            null,
            null,
            null
        )
        while (cursor.moveToNext()) {
            day = cursor.getInt(0)
            month = cursor.getInt(1)
            year = cursor.getInt(2)
            mPerDay = cursor.getInt(3)
            mTotalDodes = cursor.getInt(4)
        }
        val totalDays = mTotalDodes / mPerDay
        val startDate = Calendar.getInstance()
        startDate[Calendar.DAY_OF_MONTH] = day
        startDate[Calendar.MONTH] = month
        startDate[Calendar.YEAR] = year
        val daysBetween =
            Math.round((mNextAlarmDate!!.getTimeInMillis() - startDate.timeInMillis) as Float / (24 * 60 * 60 * 1000))
                .toLong()
        return (totalDays - daysBetween) as Int
    }

    companion object {
        private val DB_NAME: String? = "Med-Dose"
        private const val DB_VERSION = 1
        private val DB_TABLE: String? = "Medicines"
        private val KEY_ID: String? = "ID"
        private val KEY_NAME: String? = "Name"
        private val KEY_DAY: String? = "Day"
        private val KEY_MONTH: String? = "Month"
        private val KEY_YEAR: String? = "Year"
        private val KEY_TIMES_PER_DAY: String? = "TimesPerDay"
        private val KEY_TOTAL_DOSES: String? = "TotalDoses"
        private val KEY_TIMINGS: String? = "Timings"
        private val KEY_ALERT_TYPE: String? = "AlertType"
    }
}