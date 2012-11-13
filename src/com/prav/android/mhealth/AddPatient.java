package com.prav.android.mhealth;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddPatient extends Activity {
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.patient);
	    }
	 
	 public void addPatient(View v) {
		    // get access to views
		    EditText editPid = (EditText) this.findViewById(R.id.editTextPid);
		    EditText editPname = (EditText) this.findViewById(R.id.editTextPname);
		    EditText editPbgroup = (EditText) this.findViewById(R.id.editTextPbgroup);

			try {
				DBHelper dbhelper = new DBHelper(this); 
				SQLiteDatabase db = dbhelper.getWritableDatabase();
				Log.d("Account","Got Writable database");
				// execute insert command
				ContentValues values = new ContentValues();
				values.put( Database.PATIENT_ID, editPid.getText().toString());
				values.put( Database.PATIENT_NAME, editPname.getText().toString());
				values.put( Database.PATIENT_BGROUP, editPbgroup.getText().toString());
				

				long rows = db.insert(Database.PATIENT_TABLE_NAME, null, values);
				db.close();
				if ( rows > 0)  {
				    Toast.makeText(this, "Added Patient Successfully!",	Toast.LENGTH_LONG).show();
				    this.finish();
				}
				else
					Toast.makeText(this, "Sorry! Could not add patient!",	Toast.LENGTH_LONG).show();
				
			} catch (Exception ex) {
				Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
			}

		  
	  }

}
