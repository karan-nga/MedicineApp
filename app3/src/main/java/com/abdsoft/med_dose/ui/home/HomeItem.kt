package com.abdsoft.med_dose.ui.home

class HomeItem(private val medicineName: String?, private val dosageSummary: String?) {
    fun getMedicineName(): String? {
        return medicineName
    }

    fun getDosageSummary(): String? {
        return dosageSummary
    }
}