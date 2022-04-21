package com.abdsoft.med_dose.ui.dashboard

class HistoryItem(
    private val name: String?,
    private val date: String?,
    private val timesPerDay: Int,
    private val totalDosage: Int,
    private val timings: String?
) {
    fun getName(): String? {
        return name
    }

    fun getDate(): String? {
        return date
    }

    fun getTimesPerDay(): Int {
        return timesPerDay
    }

    fun getTotalDosage(): Int {
        return totalDosage
    }

    fun getTimings(): String? {
        return timings
    }
}