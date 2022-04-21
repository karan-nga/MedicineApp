package com.abdsoft.med_dose.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.abdsoft.med_dose.R

class SettingsFragment : Fragment() {
    private var settingsViewModel: SettingsViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        settingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)
        val textView = root.findViewById<TextView?>(R.id.text_settings)
        settingsViewModel!!.getText()?.observe(this) { s -> textView.text = s }
        return root
    }
}