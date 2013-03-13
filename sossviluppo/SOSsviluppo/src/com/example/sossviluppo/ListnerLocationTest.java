package com.example.sossviluppo;

//import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class ListnerLocationTest implements LocationListener {
		private TextView outputText;
		private Location loc;
	
		ListnerLocationTest(TextView output){
			loc= new Location(LocationManager.GPS_PROVIDER);
			outputText=output;
		} 
		
		public void richiesta(){
			String text="coordinate adesso: "+loc.getLatitude()+":"+loc.getLongitude();
			outputText.setText(text);
		}
		
 		@Override
		public void onLocationChanged(Location location) {
 			loc=location;
			//outputText.setText("Ora sei in: "+location.getLatitude()+" & "+location.getLongitude());
		}

		@Override
		public void onProviderDisabled(String provider) {
			outputText.setText("Segnale PERSO: "+provider);
		}

		@Override
		public void onProviderEnabled(String provider) {
			outputText.setText("Presenza segnale: "+provider);
		}

		@Override
		public void onStatusChanged(String provider, int status,Bundle extras) {
			//outputText.setText("onStatusChanged "+provider+" status: "+status);
		}
			
}
