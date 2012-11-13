package com.prav.android.mhealth;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;



public class Database {
	public static final String PATIENT_TABLE_NAME = "patient";
	public static final String PATIENT_ID = "pid";
	public static final String PATIENT_NAME = "pname";
	public static final String PATIENT_BGROUP = "pbgroup";
	
	public static Patient cursorToAccount(Cursor patients) {
		Patient patient = new Patient();
		patient.setId( patients.getString(patients.getColumnIndex(Database.PATIENT_ID)));
		patient.setPname(patients.getString(patients.getColumnIndex(Database.PATIENT_NAME)));
		patient.setPbgroup( patients.getString(patients.getColumnIndex(Database.PATIENT_BGROUP)));
        return patient;
	}
	
	public  static void populatePatients(Spinner spinnerPatients) {
		Context context = spinnerPatients.getContext();
		DBHelper dbhelper = new DBHelper(context);
		SQLiteDatabase db = dbhelper.getReadableDatabase();
		Cursor patients = db.query(Database.PATIENT_TABLE_NAME, null, null,null, null, null, null);
		ArrayList<Patient> list = new ArrayList<Patient>();

	    // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		while (patients.moveToNext()) {
			Patient p1 =  Database.cursorToAccount(patients);
			list.add(p1);
			
		}
		patients.close();
		db.close();
		dbhelper.close();
		
		ArrayAdapter<Patient> adapter = new ArrayAdapter<Patient>(context, android.R.layout.simple_spinner_item,list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerPatients.setAdapter(adapter);
	}
	public static String getPatientId(Spinner spinnerPatients) {
        Patient patient = (Patient) spinnerPatients.getSelectedItem();
        return patient.getId();
        
	}
	public static String getPatientBgroup(Spinner spinnerPatients) {
        Patient patient = (Patient) spinnerPatients.getSelectedItem();
        return patient.getPbgroup();
        
	}
	
}
