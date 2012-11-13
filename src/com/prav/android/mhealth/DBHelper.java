package com.prav.android.mhealth;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
	public static final int DB_VERSION = 1;
	public static final String DB_NAME = "patient.db";
   
	public DBHelper(Context ctx) {
		super(ctx, DB_NAME, null, DB_VERSION);
	}

	
	@Override
	public void onCreate(SQLiteDatabase db) {
          createTables(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}
	
	public void createTables(SQLiteDatabase database) {
		String patient_table_sql = "create table " + Database.PATIENT_TABLE_NAME + " ( " + 
				Database.PATIENT_ID + " INTEGER," +
				Database.PATIENT_NAME + " TEXT," +
				Database.PATIENT_BGROUP  + " TEXT)";
				
        try {
		   database.execSQL(patient_table_sql);
		   Log.d("Patient","Table created!");
		   
        }
        catch(Exception ex) {
        	Log.d("Patient", "Error in DBHelper.onCreate() : " + ex.getMessage());
        }
	}

}