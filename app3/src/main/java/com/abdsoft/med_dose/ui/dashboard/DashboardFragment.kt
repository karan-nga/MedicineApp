package com.abdsoft.med_dose.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdsoft.med_dose.HomeActivity
import com.abdsoft.med_dose.R
import com.abdsoft.med_dose.db.DatabaseHelper

class DashboardFragment : Fragment() {
    lateinit var dashboardViewModel: DashboardViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerView.Adapter<*>
    private val root: View? = null
    lateinit var homeActivity: HomeActivity
    lateinit var databaseHelper: DatabaseHelper
    lateinit  var historyItems: MutableList<HistoryItem?>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView = root.findViewById<TextView?>(R.id.text_dashboard)
        dashboardViewModel.getText()?.observe(this) {
            //                textView.setText(s);
        }
        recyclerView = root.findViewById(R.id.recycler_view_medicine_history)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(activity))
        historyItems = ArrayList()
        loadHistory()
        return root
    }

    fun loadHistory() {
        databaseHelper = DatabaseHelper(context)
        historyItems = databaseHelper.getMedicineHistory()!!
        adapter = HistoryAdapter(historyItems, activity)
        recyclerView.setAdapter(adapter)
    }
}