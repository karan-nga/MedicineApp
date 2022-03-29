package com.rawtooth.medicineapp.cart

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.ActivityTimeDateSelectionBinding
import java.text.SimpleDateFormat
import java.util.*

class TimeDateSelection : AppCompatActivity(), View.OnClickListener {
    lateinit var binding:ActivityTimeDateSelectionBinding
    lateinit var myCalender: Calendar
    lateinit var dateSetListner: DatePickerDialog.OnDateSetListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTimeDateSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.dateEdt.setOnClickListener(this)
        binding.patientDetailsBtn.setOnClickListener{
            startActivity(Intent(this,PatientDetailsActivity::class.java))
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.dateEdt ->{
                    setListner()
                }
            }
        }
    }

    private fun setListner() {
        myCalender= Calendar.getInstance()
        dateSetListner=DatePickerDialog.OnDateSetListener{ datePicker: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            myCalender.set(Calendar.YEAR,year)
            myCalender.set(Calendar.MONTH, month)
            myCalender.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateDate()
        }
        val datePickerDialog=DatePickerDialog(
            this,dateSetListner,myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH),myCalender.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.datePicker.minDate=System.currentTimeMillis()
        datePickerDialog.show()
    }

    private fun updateDate() {
        val myformat="EEEE, d MMM yyyy"
        val sdf=  SimpleDateFormat(myformat)
        binding.dateEdt.setText(sdf.format(myCalender))
    }
}