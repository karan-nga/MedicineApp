package com.abdsoft.med_dose.ui.home

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdsoft.med_dose.AlarmActivity
import com.abdsoft.med_dose.HomeActivity
import com.abdsoft.med_dose.R
import com.abdsoft.med_dose.db.DatabaseHelper
import com.abdsoft.med_dose.ui.home.time.TimeAdapter
import com.abdsoft.med_dose.ui.home.time.TimeSelectorItem
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.textview.MaterialTextView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class AddDialog(private val homeFragment: HomeFragment?) : DialogFragment(),
    Toolbar.OnMenuItemClickListener {
    private var toolbar: MaterialToolbar? = null
    private var textViewDate: MaterialTextView? = null
    private var editTextMedicineName: EditText? = null
    private var chipGroupScheduleTimes: ChipGroup? = null
    private var chipGroupAlertType: ChipGroup? = null
    private var chipSelected: Chip? = null
    private val chipArrayIds: IntArray? =
        intArrayOf(R.id.chip1, R.id.chip2, R.id.chip3, R.id.chip4, R.id.chip5)
    private val chipAlertArrayIds: IntArray? = intArrayOf(R.id.chip_notification, R.id.chip_alarm)
    private var timeSelectorItems: MutableList<TimeSelectorItem?>? = null
    private var mPerDay = 1
    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    private var numberPicker: NumberPicker? = null
    private var noOfTotalTimes = 0
    private var alertType: String? = null
    lateinit var calendar: Calendar

    /* public static AddDialog display(FragmentManager fragmentManager) {
        AddDialog exampleDialog = new AddDialog();
        exampleDialog.show(fragmentManager, TAG);
        return exampleDialog;
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppTheme_FullScreenDialog)
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window?.setLayout(width, height)
            dialog.window?.setWindowAnimations(R.style.AppTheme_Slide)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (inflater != null) {
            super.onCreateView(inflater, container, savedInstanceState)
        }
        val root = inflater?.inflate(R.layout.add_medicine_dialog, container, false)
        toolbar = root?.findViewById(R.id.toolbar)
        textViewDate = root?.findViewById(R.id.text_view_select_date)
        editTextMedicineName = root?.findViewById(R.id.editText_medicine_name)
        chipGroupScheduleTimes = root?.findViewById(R.id.chip_group_times)
        recyclerView = root?.findViewById(R.id.recycler_view_time)
        numberPicker = root?.findViewById(R.id.number_picker_number_doses)
        chipGroupAlertType = root?.findViewById(R.id.chip_group_alert_type)
        chipSelected = chipGroupAlertType?.let { root?.findViewById(it.getCheckedChipId()) }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (view != null) {
            super.onViewCreated(view, savedInstanceState)
        }
        toolbar?.setNavigationOnClickListener(View.OnClickListener { v: View? ->
            Toast.makeText(this@AddDialog.context, "Close Pressed", Toast.LENGTH_SHORT).show()
            dismiss()
        })
        toolbar?.setTitle("Add Medicine")
        toolbar?.inflateMenu(R.menu.add_dialog_menu)
        toolbar?.setOnMenuItemClickListener(this)
        val c = Calendar.getInstance()
        val mYear = c[Calendar.YEAR] // current year
        val mMonth = c[Calendar.MONTH] // current month
        val mDay = c[Calendar.DAY_OF_MONTH] // current day
        calendar = Calendar.getInstance()
        calendar.set(mYear, mMonth, mDay)
        var format = SimpleDateFormat("EEEE, MMMM d, yyyy")
        textViewDate?.setText(format.format(calendar.getTime()))
        textViewDate?.setOnClickListener(View.OnClickListener { view1: View? ->
            val datePickerDialog = activity?.let {
                DatePickerDialog(
                    it,
                    DatePickerDialog.OnDateSetListener { view2: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                        // set day of month , month and year value in the edit text
                        calendar.set(year, monthOfYear, dayOfMonth)
                        val format1 = SimpleDateFormat("EEEE, MMMM d, yyyy")
                        textViewDate!!.setText(format1.format(calendar.getTime()))
                    }, mYear, mMonth, mDay
                )
            }
            if (datePickerDialog != null) {
                datePickerDialog.show()
            }
        })
        val mCurrentTime = Calendar.getInstance()
        val hour = mCurrentTime[Calendar.HOUR]
        val minute = mCurrentTime[Calendar.MINUTE]
        format = SimpleDateFormat("h:mm a")
        //        textViewTime.setText(format.format(mCurrentTime.getTime()));

/*
        textViewTime.setOnClickListener(view1 -> {
            TimePickerDialog mTimePicker;
            mTimePicker = new TimePickerDialog(getActivity(), (timePicker, selectedHour, selectedMinute) -> {
                calendar.set(Calendar.HOUR, selectedHour);
                calendar.set(Calendar.MINUTE, selectedMinute);
                SimpleDateFormat format12 = new SimpleDateFormat("h:mm a");
                textViewTime.setText(format12.format(calendar.getTime()));
            }, hour, minute, false);//Yes 24 hour time
            mTimePicker.show();
        });
*/recyclerView?.setHasFixedSize(true)
        recyclerView?.setLayoutManager(LinearLayoutManager(activity))
        timeSelectorItems = ArrayList()
        HomeActivity.Companion.timeItems?.clear()
        if (mPerDay > 0) {
            numberPicker?.setMinValue(mPerDay)
        } else {
            numberPicker?.setMinValue(0)
        }
        (timeSelectorItems as ArrayList<TimeSelectorItem?>).clear()
        for (i in 0 until mPerDay) {
            val timeSelectorItem = TimeSelectorItem("Pick a Time")
            (timeSelectorItems as ArrayList<TimeSelectorItem?>).add(timeSelectorItem)
        }
        adapter = TimeAdapter(timeSelectorItems, activity)
        recyclerView?.setAdapter(adapter)
        chipGroupScheduleTimes?.setOnCheckedChangeListener(ChipGroup.OnCheckedChangeListener { chipGroup: ChipGroup?, id: Int ->
            val chip: Chip = chipGroup!!.findViewById(id)
            if (chip != null) {
                for (iTmp in chipArrayIds?.indices!!) {
                    if (chipGroup.getCheckedChipId() == chipArrayIds.get(iTmp)) {
                        mPerDay = iTmp + 1
                        //                        Toast.makeText(getContext(), String.valueOf(mPerDay), Toast.LENGTH_LONG).show();
                        HomeActivity.Companion.timeItems?.clear()
                        if (mPerDay > 0) {
                            numberPicker?.setMinValue(mPerDay)
                        } else {
                            numberPicker?.setMinValue(0)
                        }
                        (timeSelectorItems as ArrayList<TimeSelectorItem?>).clear()
                        for (i in 0 until mPerDay) {
                            val timeSelectorItem = TimeSelectorItem("Pick a Time")
                            (timeSelectorItems as ArrayList<TimeSelectorItem?>).add(timeSelectorItem)
                        }
                        adapter = TimeAdapter(timeSelectorItems, activity)
                        recyclerView?.setAdapter(adapter)
                    }
                }
            }
        })
        numberPicker?.setMaxValue(50)
        numberPicker?.setMinValue(mPerDay)
        numberPicker?.setOnValueChangedListener(NumberPicker.OnValueChangeListener { numberPicker, i, i1 ->
            noOfTotalTimes = numberPicker.value
            Log.d("picker value", noOfTotalTimes.toString())
        })
        chipGroupAlertType?.setOnCheckedChangeListener(ChipGroup.OnCheckedChangeListener { chipGroup: ChipGroup?, id: Int ->
            chipSelected = chipGroup?.findViewById(id)
            if (chipSelected != null) alertType =
                chipSelected!!.getText().toString() else showAlertDialog("Alert Type")
        })
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        val homeActivity = activity as HomeActivity?
        val medicineName = editTextMedicineName?.getText().toString()
        if (medicineName.isEmpty()) {
            editTextMedicineName?.setError("Enter a name")
            return false
        }
        if (HomeActivity.Companion.timeItems?.size != mPerDay) {
            showAlertDialog("Time")
            return false
        }
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val noOfTimesPerDay = mPerDay
        noOfTotalTimes = numberPicker!!.getValue()
        val noOfDoses = noOfTotalTimes
        alertType = chipSelected!!.getText().toString()
        val reminderAlterType = alertType
        val takeTime = ArrayList<String?>()
        for (i in HomeActivity.Companion.timeItems!!.indices) {
            takeTime.add(
                HomeActivity.Companion.timeItems!!.get(i)!!.getHour()
                    .toString() + ":" + HomeActivity.Companion.timeItems!!.get(i)?.getMinute()
            )
        }
        val json = JSONObject()
        try {
            json.put("timingArrays", JSONArray(takeTime))
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        val timingList = json.toString()
        Log.d(TAG, "arrayList:$timingList")
        val databaseHelper = DatabaseHelper(context)
        databaseHelper.insertNewMedicine(
            medicineName,
            day,
            month,
            year,
            noOfTimesPerDay,
            noOfDoses,
            timingList,
            reminderAlterType
        )
        val calendar = Calendar.getInstance()
        calendar[Calendar.HOUR_OF_DAY] = HomeActivity.Companion.timeItems!!.get(0)!!.getHour()
        calendar[Calendar.MINUTE] = HomeActivity.Companion.timeItems!!.get(0)!!.getMinute()
        calendar[Calendar.SECOND] = 0
        calendar[Calendar.MILLISECOND] = 0
        when (alertType) {
            "Notification" -> setNotification(calendar, medicineName)
            "Alarm" -> setAlarm(calendar, medicineName)
            else -> {
                setAlarm(calendar, medicineName)
                setNotification(calendar, medicineName)
            }
        }
        Log.i(
            "AddDialog.java",
            calendar[Calendar.HOUR_OF_DAY].toString() + ":" + calendar[Calendar.MINUTE]
        )
        homeFragment?.loadMedicines()
        dismiss()
        return true
    }

    fun setAlarm(mAlarmTime: Calendar?, medicineName: String?) {
        val intent = Intent(activity, AlarmActivity::class.java)
        intent.putExtra("medicineName", medicineName)
        val operation =
            PendingIntent.getActivity(activity, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        /** Getting a reference to the System Service ALARM_SERVICE  */
        val alarmManagerNew = activity?.getSystemService(
            Context.ALARM_SERVICE
        ) as AlarmManager

//        alarmManagerNew.setRepeating(AlarmManager.RTC_WAKEUP, mAlarmTime.getTimeInMillis(),
//                AlarmManager.INTERVAL_DAY * 7, operation);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (mAlarmTime != null) {
                alarmManagerNew.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    mAlarmTime.getTimeInMillis(),
                    operation
                )
            }
        } else if (mAlarmTime != null) {
            alarmManagerNew.setExact(
                AlarmManager.RTC_WAKEUP,
                mAlarmTime.getTimeInMillis(),
                operation
            )
        }
    }

    private fun setNotification(mNotificationTime: Calendar?, medicineName: String?) {
        val alarmManager = activity?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val notificationIntent = Intent(context, AlarmReceiver::class.java)
        notificationIntent.putExtra("medicineName", medicineName)
        val broadcast = PendingIntent.getBroadcast(
            context,
            100,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        mNotificationTime?.getTimeInMillis()?.let {
            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                it,
                broadcast
            )
        }
        Toast.makeText(
            context,
            mNotificationTime?.get(Calendar.HOUR_OF_DAY).toString() + ":" + mNotificationTime?.get(
                Calendar.MINUTE
            ),
            Toast.LENGTH_SHORT
        ).show()
        Log.d(
            TAG,
            mNotificationTime?.get(Calendar.HOUR_OF_DAY).toString() + ":" + mNotificationTime?.get(
                Calendar.MINUTE
            )
        )
    }

    fun showAlertDialog(nonSelectedItem: String?) {
        val builder = activity?.let {
            AlertDialog.Builder(
                it
            )
        }
        builder?.setMessage("Please select all the fields or enter all the values to move forward.\n\nNon-selected item(s) found: \n$nonSelectedItem")
            ?.setTitle("Select all fields to continue")
        if (builder != null) {
            builder.setNeutralButton("OK") { dialog: DialogInterface?, which: Int -> dialog?.dismiss() }
        }
        val dialog = builder?.create()
        if (dialog != null) {
            dialog.show()
        }
    }

    companion object {
        val TAG: String? = "Add_Dialog"
    }
}