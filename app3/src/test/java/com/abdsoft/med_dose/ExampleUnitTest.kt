package com.abdsoft.med_dose

import androidx.lifecycle.ViewModelProvider.get
import androidx.navigation.ui.AppBarConfiguration.Builder.build
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import rm.com.clocks.ClockImageView.animateToTime
import com.abdsoft.med_dose.db.DatabaseHelper
import com.abdsoft.med_dose.ui.home.HomeItem
import com.abdsoft.med_dose.ui.dashboard.HistoryItem
import com.abdsoft.med_dose.ui.home.time.TimeSelectorItem
import com.abdsoft.med_dose.HomeActivity
import com.abdsoft.med_dose.ui.home.TimeItem
import com.abdsoft.med_dose.ui.home.time.TimeAdapter
import com.abdsoft.med_dose.ui.home.AddDialog
import com.abdsoft.med_dose.AlarmActivity
import com.abdsoft.med_dose.ui.home.HomeViewModel
import androidx.lifecycle.ViewModelProviders
import com.abdsoft.med_dose.ui.home.HomeAdapter
import com.abdsoft.med_dose.ui.settings.SettingsViewModel
import com.abdsoft.med_dose.ui.dashboard.DashboardViewModel
import com.abdsoft.med_dose.ui.dashboard.HistoryAdapter
import org.junit.Assert
import org.junit.Test
import rm.com.clocks.ClockImageView

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        Assert.assertEquals(4, (2 + 2).toLong())
    }
}