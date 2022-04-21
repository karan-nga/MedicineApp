package com.rawtooth.medicineapp.fragments.users

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdsoft.med_dose.HomeActivity

import com.rawtooth.medicineapp.databinding.ActivityUserReminderBinding

class user_reminder : AppCompatActivity() {
    lateinit var binding:ActivityUserReminderBinding
//    private lateinit var picker : MaterialTimePicker
//    private lateinit var calendar: Calendar
//    private lateinit var alarmManager: AlarmManager
//    private lateinit var pendingIntent: PendingIntent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserReminderBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.whole.setOnClickListener{
           startActivity(Intent(this,HomeActivity::class.java))
       }
    }
//        createNotificationChannel()
//
//        binding.selectTimeBtn.setOnClickListener {
//
//            showTimePicker()
//
//        }
//        binding.setAlarmBtn.setOnClickListener {
//
//            setAlarm()
//
//        }
//
//        binding.cancelAlarmBtn.setOnClickListener {
//
//            cancelAlarm()
//
//        }
//
//    }
//
//    private fun cancelAlarm() {
//
//
//        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
//        val intent = Intent(this,AlarmReceiver::class.java)
//
//        pendingIntent = PendingIntent.getBroadcast(this,0,intent,0)
//
//        alarmManager.cancel(pendingIntent)
//        Toast.makeText(this,"Alarm Cancelled",Toast.LENGTH_LONG).show()
//
//
//
//    }
//
//    private fun setAlarm() {
//
//
//        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
//        val intent = Intent(this,AlarmReceiver::class.java)
//
//        pendingIntent = PendingIntent.getBroadcast(this,0,intent,0)
//
//        alarmManager.setRepeating(
//
//            AlarmManager.RTC_WAKEUP,calendar.timeInMillis,
//            AlarmManager.INTERVAL_DAY,pendingIntent
//
//        )
//
//        Toast.makeText(this,"Alarm set Successfuly",Toast.LENGTH_SHORT).show()
//
//    }
//
//    private fun showTimePicker() {
//
//        picker = MaterialTimePicker.Builder()
//            .setTimeFormat(TimeFormat.CLOCK_12H)
//            .setHour(12)
//            .setMinute(0)
//            .setTitleText("Select Alarm Time")
//            .build()
//
//        picker.show(supportFragmentManager,"medicine")
//
//        picker.addOnPositiveButtonClickListener {
//
//            if (picker.hour > 12){
//
//                binding.selectedTime.text =
//                    String.format("%02d",picker.hour - 12) + " : " + String.format(
//                        "%02d",
//                        picker.minute
//                    ) + "PM"
//
//
//            }else{
//
//                String.format("%02d",picker.hour) + " : " + String.format(
//                    "%02d",
//                    picker.minute
//                ) + "AM"
//
//            }
//
//            calendar = Calendar.getInstance()
//            calendar[Calendar.HOUR_OF_DAY] = picker.hour
//            calendar[Calendar.MINUTE] = picker.minute
//            calendar[Calendar.SECOND] = 0
//            calendar[Calendar.MILLISECOND] = 0
//
//        }
//
//    }
//
//    private fun createNotificationChannel() {
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//
//            val name : CharSequence = "foxandroidReminderChannel"
//            val description = "Channel For Alarm Manager"
//            val importance = NotificationManager.IMPORTANCE_HIGH
//            val channel = NotificationChannel("foxandroid",name,importance)
//            channel.description = description
//            val notificationManager = getSystemService(
//                NotificationManager::class.java
//            )
//
//            notificationManager.createNotificationChannel(channel)
//        }
//
//    }
}