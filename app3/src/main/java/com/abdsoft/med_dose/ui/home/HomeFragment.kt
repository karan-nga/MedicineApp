package com.abdsoft.med_dose.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdsoft.med_dose.HomeActivity
import com.abdsoft.med_dose.R
import com.abdsoft.med_dose.db.DatabaseHelper
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class HomeFragment : Fragment() {
    private var homeViewModel: HomeViewModel? = null
    lateinit var recyclerView: RecyclerView
    private var adapter: RecyclerView.Adapter<*>? = null
    lateinit var root: View
    private val medicineNames: Array<String?>? = null
    private val dosageNames: Array<String?>? = null
    var homeActivity: HomeActivity? = null
    var databaseHelper: DatabaseHelper? = null
    private var homeItems: MutableList<HomeItem?>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView = root.findViewById<TextView?>(R.id.text_home)
        homeViewModel!!.getText()?.observe(this) {
            //                textView.setText(s);
        }
        recyclerView = root.findViewById(R.id.recycler_view_medicine)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(activity))
        homeItems = ArrayList()

        /*medicineNames = new String[]{"Crocin", "Panadol", "Cipla", "Genx Vast", "K-ion"};
        dosageNames = new String[]{"Twice - Day and Night", "Once - Night", "Once - Morning", "Once-Night", "Once-Night"};

        for (int iTmp = 0; iTmp < medicineNames.length; iTmp++)
        {
            HomeItem homeItem = new HomeItem(medicineNames[iTmp], dosageNames[iTmp]);
            homeItems.add(homeItem);
        }

        adapter = new HomeAdapter(homeItems, getActivity());
        recyclerView.setAdapter(adapter);*/loadMedicines()
        val fabAddMedicine: ExtendedFloatingActionButton = root.findViewById(R.id.fab_add_medicine)
        fabAddMedicine.setOnClickListener {
            Toast.makeText(context, "Showing Add Dialog", Toast.LENGTH_SHORT).show()
            val addMedicineDialog = AddDialog(this@HomeFragment)
            fragmentManager?.let { it1 -> addMedicineDialog.show(it1, "Add_Dialog") }
        }
        return root
    }

    fun loadMedicines() {
        databaseHelper = DatabaseHelper(context)
        homeItems = databaseHelper!!.getMedicineList()
        adapter = HomeAdapter(homeItems, activity)
        recyclerView.setAdapter(adapter)
    }
}