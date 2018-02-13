package com.saastech.amcmanager;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class CustomerDetails extends Activity {
	Button addbutton,refreshbutt,previousbutt;
	ListView list;
	Cursor mCursor;
	DisplayAdapter displayAdapter;
	Customer customer;
	MySQLiteHelper myHelper;
	SQLiteDatabase db;
	    private ArrayList<String> cust_id=new ArrayList<String>();
		private ArrayList<String> cust_name=new ArrayList<String>();
		private ArrayList<String> cust_mobile1=new ArrayList<String>();
		private ArrayList<String> cust_mobile2=new ArrayList<String>();
		private ArrayList<String> cust_address=new ArrayList<String>();
		private ArrayList<String> cust_email=new ArrayList<String>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_details);
		addbutton=(Button) findViewById(R.id.btnAdd_customerdetails);
		refreshbutt=(Button) findViewById(R.id.btnrefresh_customerdetails);
		previousbutt=(Button) findViewById(R.id.btnprevious_customerdetails);
		list=(ListView) findViewById(R.id.List_customerdetails);
		
		//decaler customer object
	    customer=new Customer();
	    
	    //cretae object for DataBase Class
	    myHelper=new MySQLiteHelper(this);
	    
		
		displayData();
		addbutton.setOnClickListener(new OnClickListener() { 
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intaddnewcust=new Intent(CustomerDetails.this,AddNewCustomer.class);
				startActivity(intaddnewcust);
				
			}
		});
		
		refreshbutt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				displayData();
			}
		});
		previousbutt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				
			}
		});
		
	}
	/**
     * displays data from SQLite
     */
    private void displayData() {
        db = myHelper.getWritableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM " + myHelper.TABLE_CUSTOMER, null);
        Log.d("Selct Query", "All Data");
        cust_id.clear();
        cust_name.clear();
        cust_mobile1.clear();
        cust_mobile2.clear();
        cust_address.clear();
        cust_email.clear();
        Log.d("After The","clear");
        if (mCursor.moveToFirst()) {
            do {
                cust_id.add(mCursor.getString(mCursor.getColumnIndex(myHelper.CUST_ID)));
                cust_name.add(mCursor.getString(mCursor.getColumnIndex(myHelper.CUST_NAME)));
                cust_mobile1.add(mCursor.getString(mCursor.getColumnIndex(myHelper.CUST_MOBILE_1)));
                cust_mobile2.add(mCursor.getString(mCursor.getColumnIndex(myHelper.CUST_MOBILE_2)));
                cust_address.add(mCursor.getString(mCursor.getColumnIndex(myHelper.CUST_ADDRESS)));
                cust_email.add(mCursor.getString(mCursor.getColumnIndex(myHelper.CUST_EMAIL)));

            } while (mCursor.moveToNext());
            Log.d("Inside","While Loop");
        }
        DisplayAdapter disadpt = new DisplayAdapter(CustomerDetails.this,cust_id, cust_name, cust_mobile1,cust_mobile2,cust_address,cust_email);
        list.setAdapter(disadpt);
        Log.d("After", "SetAdapter");
        mCursor.close();
    }

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.customer_details, menu);
		return true;
	}

}
