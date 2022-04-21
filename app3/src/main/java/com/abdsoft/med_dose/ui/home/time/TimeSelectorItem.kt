package com.abdsoft.med_dose.ui.home.time

class TimeSelectorItem(private var time: String?) {
    fun getTime(): String? {
        return time
    }

    fun setTime(time: String?) {
        this.time = time
    }
}