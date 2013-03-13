package com.example.sossviluppo;


import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {


	String numero;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
        // Otteniamo il riferimento alla TextView di output
        final TextView outputText = (TextView)findViewById(R.id.outputText); 
        
        //impostiamo le coordinate
        // Otteniamo il riferimento al LocationManager
     	final LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
     	outputText.setText("location manager di android creato");
  	
     	// Registriamo il LocationListener al provider GPS
     	final ListnerLocationTest LLT= new ListnerLocationTest(outputText); 
     	locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,0, LLT);
        // Gestiamo il bottone        
        Button invia = (Button)findViewById(R.id.inviaButton);
        invia.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				//richiesta coordinate
				LLT.richiesta();
			}}
        );        
	}
	
	public void onResume(){
		super.onResume();
		getSetting();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Aggiungiamo il solo MenuItem con l'intent per le opzioni
		MenuItem menuItem = menu.add(Menu.FIRST, Menu.FIRST, 1, "Preferences");
		menuItem.setIntent(new Intent(this, Configuration.class));
			
		getSetting();
		return true;
	}

	private void getSetting(){
		TextView helloText = (TextView) findViewById(R.id.helloText);

		// Otteniamo il riferimento alle SharedPreferences
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		// Otteniamo i valori delle preferenze
		numero = prefs.getString("textData", "");
		if(numero=="")
			 helloText.setText("Imposta il numero da chiamare nel menù dell'app!!");
		else
			 helloText.setText("Pronto per avvertire: "+numero);
	}
}
