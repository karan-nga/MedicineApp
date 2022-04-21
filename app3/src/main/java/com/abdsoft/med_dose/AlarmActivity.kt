package com.abdsoft.med_dose

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import android.os.Vibrator
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.abdsoft.med_dose.db.DatabaseHelper
import rm.com.clocks.ClockImageView
import java.text.SimpleDateFormat
import java.util.*

class AlarmActivity : AppCompatActivity() {
    lateinit var textViewMedicineName: TextView
     lateinit var textViewTime: TextView
   lateinit var mVibrator: Vibrator
   lateinit var buttonDismiss: Button
   lateinit var buttonSnooze: Button
    var buttonTake: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
        val intent = intent
        val clockImageView = findViewById<ClockImageView?>(R.id.clock_alarm)
        val mCurrentTime = Calendar.getInstance()
        clockImageView.animateToTime(
            mCurrentTime[Calendar.HOUR_OF_DAY],
            mCurrentTime[Calendar.MINUTE]
        )
        val medicineName = intent.getStringExtra("medicineName")
        textViewMedicineName = findViewById(R.id.text_view_medicine_name_alarm)
        textViewMedicineName.setText(medicineName)
        textViewTime = findViewById(R.id.text_view_time_alarm)
        val format = SimpleDateFormat("h:mm a")
        textViewTime.setText(format.format(mCurrentTime.time))
        mVibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val pattern = longArrayOf(0, 1000, 1000)
        mVibrator.vibrate(pattern, 0)
        var alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        }
        val ringtone = RingtoneManager.getRingtone(applicationContext, alarmUri)
        ringtone.play()
        val databaseHelper = DatabaseHelper(this)
        val timingList = databaseHelper.getTimings(medicineName)
        if (timingList != null) {
            for (i in timingList.indices) {
                timingList[i]?.let { Log.i(AlarmActivity::class.java.name, it) }
            }
        }
        val nextAlarmTime = Calendar.getInstance()
        nextAlarmTime[Calendar.SECOND] = 0
        nextAlarmTime[Calendar.MILLISECOND] = 0
        buttonDismiss = findViewById(R.id.button_dismiss)
        buttonDismiss.setOnClickListener(View.OnClickListener { v: View? ->
            if (timingList != null) {
                for (i in timingList.indices) {
                    var time: Array<String?> = timingList[i]?.split(":")!!.toTypedArray()
                    nextAlarmTime[Calendar.HOUR_OF_DAY] = time[0]!!.toInt()
                    nextAlarmTime[Calendar.MINUTE] = time[1]!!.toInt()
                    if (mCurrentTime.before(nextAlarmTime)) {
                        break
                    } else if (mCurrentTime.after(nextAlarmTime) && i == timingList.size - 1) {
                        nextAlarmTime[Calendar.DAY_OF_MONTH] = nextAlarmTime[Calendar.DAY_OF_MONTH] + 1
                        time = timingList[0]?.split(":")!!.toTypedArray()
                        nextAlarmTime[Calendar.HOUR_OF_DAY] = time[0]!!.toInt()
                        nextAlarmTime[Calendar.MINUTE] = time[1]!!.toInt()
                    }
                }
            }
            mVibrator.cancel()
            ringtone.stop()
            Log.i("daysLeft", databaseHelper.noOfDaysLeft(medicineName, nextAlarmTime).toString())
            if (databaseHelper.noOfDaysLeft(
                    medicineName,
                    nextAlarmTime
                ) > 0
            ) setAlarm(nextAlarmTime, medicineName)
            finish()
        })
        buttonSnooze = findViewById(R.id.button_snooze)
        buttonSnooze.setOnClickListener(View.OnClickListener { v: View? ->
            nextAlarmTime[Calendar.MINUTE] = nextAlarmTime[Calendar.MINUTE] + 5
            mVibrator.cancel()
            ringtone.stop()
            setAlarm(nextAlarmTime, medicineName)
            finish()
        })
    }

    fun setAlarm(mAlarmTime: Calendar?, medicineName: String?) {
        val intent = Intent(this, AlarmActivity::class.java)
        intent.putExtra("medicineName", medicineName)
        val operation =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        /** Getting a reference to the System Service ALARM_SERVICE  */
        val alarmManagerNew = getSystemService(
            Context.ALARM_SERVICE
        ) as AlarmManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManagerNew.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                mAlarmTime!!.getTimeInMillis(),
                operation
            )
        } else alarmManagerNew.setExact(
            AlarmManager.RTC_WAKEUP,
            mAlarmTime!!.getTimeInMillis(),
            operation
        )
    }
}