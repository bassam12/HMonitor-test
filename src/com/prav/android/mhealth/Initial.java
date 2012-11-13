package com.prav.android.mhealth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;



public class Initial extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.initial);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_patient , menu);
        return true;
    }
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.addpatient:
            // Launch the DeviceListActivity to see devices and do scan
            Intent AddPatientIntent = new Intent(this, AddPatient.class);
            startActivity(AddPatientIntent);
            return true;
        case R.id.bluetooth:
            Intent BluetoothChatIntent = new Intent(this,BluetoothChat.class);
            startActivity(BluetoothChatIntent);
            return true;
        }
        return false;
    }

}
