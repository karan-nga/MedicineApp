package com.abdsoft.med_dose.ui.home.time

import android.app.TimePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.recyclerview.widget.RecyclerView
import com.abdsoft.med_dose.HomeActivity
import com.abdsoft.med_dose.R
import com.abdsoft.med_dose.ui.home.TimeItem
import com.google.android.material.textview.MaterialTextView
import java.text.SimpleDateFormat
import java.util.*

class TimeAdapter(
    private val timeSelectorItems: MutableList<TimeSelectorItem?>?,
    private val context: Context?
) : RecyclerView.Adapter<TimeAdapter.ViewHolder?>() {
    var homeActivity: HomeActivity? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.select_time_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        homeActivity = context as HomeActivity?
        val timeSelectorItem = timeSelectorItems?.get(position)
        if (timeSelectorItem != null) {
            holder.textViewTime!!.setText(timeSelectorItem.getTime())
        }
        val mCurrentTime = Calendar.getInstance()
        val hour = mCurrentTime[Calendar.HOUR_OF_DAY]
        val minute = mCurrentTime[Calendar.MINUTE]
        holder.textViewTime!!.setOnClickListener(View.OnClickListener { view1: View? ->
            val mTimePicker: TimePickerDialog
            mTimePicker = TimePickerDialog(
                context,
                { timePicker: TimePicker?, selectedHour: Int, selectedMinute: Int ->
                    mCurrentTime[Calendar.HOUR_OF_DAY] = selectedHour
                    mCurrentTime[Calendar.MINUTE] = selectedMinute
                    val format12 = SimpleDateFormat("h:mm a")
                    holder.textViewTime!!.setText(format12.format(mCurrentTime.time))
                    for (j in HomeActivity.Companion.timeItems!!.indices) {
                        if (HomeActivity.Companion.timeItems!!.get(j)
                                !!.getPosInRecyclerView() == position
                        ) {
                            HomeActivity.Companion.timeItems!!.removeAt(j)
                            break
                        }
                    }
                    HomeActivity.Companion.timeItems!!.add(
                        TimeItem(
                            selectedHour,
                            selectedMinute,
                            position
                        )
                    )
                },
                hour,
                minute,
                false
            ) //Yes 24 hour time
            mTimePicker.show()
        })
    }

    override fun getItemCount(): Int {
        return timeSelectorItems!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewTime: MaterialTextView?

        init {
            textViewTime = itemView.findViewById(R.id.text_view_select_time)
        }
    }
}