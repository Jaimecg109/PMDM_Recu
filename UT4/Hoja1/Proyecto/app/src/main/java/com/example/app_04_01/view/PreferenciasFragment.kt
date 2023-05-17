package com.example.app_04_01.view

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.app_04_01.R

class PreferenciasFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferencias, rootKey)
    }
}