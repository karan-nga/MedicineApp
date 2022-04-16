package com.rawtooth.medicineapp.consult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.ActivityDoctorConsultBinding

class doctor_consult : AppCompatActivity() {
//    lateinit var recyclerAdapter: Adapter
//    lateinit var countryListRecyclerview:RecyclerView
    lateinit var binding:ActivityDoctorConsultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDoctorConsultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomNav=BottomSheetDoc()
        binding.bookappointment.setOnClickListener{
            bottomNav.show(supportFragmentManager,"BottomSheet")
        }

//        val bookappointment=findViewById<MaterialButton>(R.id.bookappointment)
//        bookappointment.setOnClickListener{
//            openbottomsheet()
//        }

    }
//    fun openbottomsheet(){
//        val dialog = BottomSheetDialog(this)
//        val view = layoutInflater.inflate(R.layout.consult,null)
//        dialog.setContentView(view)
//
//        dialog.show()
//
//
//        val users = ArrayList<Model_Details>()
//        users.add(Model_Details("Report 1", "https://tinypng.com/images/example-orig.png"))
//        users.add(Model_Details("Report 2", "https://tinypng.com/images/example-orig.png"))
//        users.add(Model_Details("Report 3", "https://tinypng.com/images/example-orig.png"))
//        users.add(Model_Details("Report 4", "https://tinypng.com/images/example-orig.png"))
//        users.add(Model_Details("Report 5", "https://tinypng.com/images/example-orig.png"))
//
//
//        countryListRecyclerview=findViewById(R.id.prevreport2)!!
//        recyclerAdapter=Adapter()
//        countryListRecyclerview.layoutManager=LinearLayoutManager(this)
//
//    }
    }
