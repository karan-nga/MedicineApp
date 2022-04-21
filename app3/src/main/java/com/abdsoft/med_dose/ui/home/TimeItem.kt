package com.abdsoft.med_dose.ui.home

class TimeItem(private val hour: Int, private var minute: Int, private var posInRecyclerView: Int) {
    fun getHour(): Int {
        return hour
    }

    fun getMinute(): Int {
        return minute
    }

    fun getPosInRecyclerView(): Int {
        return posInRecyclerView
    }
}