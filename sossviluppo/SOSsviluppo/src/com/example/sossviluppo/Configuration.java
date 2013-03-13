package com.example.sossviluppo;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Configuration extends PreferenceActivity {
	
    /** Called when the activity is first created. */
    @SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource (R.xml.preferences);
    }	

}