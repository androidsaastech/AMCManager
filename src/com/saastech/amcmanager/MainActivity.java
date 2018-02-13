package com.saastech.amcmanager;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	Customer customer;
	Service service;
	ListView lisView;
	Cursor mCursor;
	DisplayAdapter displayAdapter;
	Button disbutton,repbutton,refrbutton,addbutton,searchbutton;
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
		setContentView(R.layout.activity_main);
		disbutton=(Button) findViewById(R.id.btn_display);
		repbutton=(Button) findViewById(R.id.btn_report);
		refrbutton=(Button) findViewById(R.id.btn_refresh);
		addbutton=(Button) findViewById(R.id.btn_add_customer);
		searchbutton=(Button) findViewById(R.id.btn_search);
		lisView=(ListView) findViewById(R.id.List);
		
		//decaler customer object
	    customer=new Customer();
	    
	    //cretae object for DataBase Class
	    myHelper=new MySQLiteHelper(this);
	    
	    displayData();
	    
	   	    //Display Customer Details 
		disbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intdiplay=new Intent(MainActivity.this,CustomerDetails.class);
				startActivity(intdiplay);
				
			}
		});
		/*searchbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent(MainActivity.this,FindingDates.class);
				startActivity(in);
			}
		});*/
		
		//Add Customer Dteails Manually
		addbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				Intent intdiplay=new Intent(MainActivity.this,AddNewCustomer.class);
				startActivity(intdiplay);
								
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
        DisplayAdapter disadpt = new DisplayAdapter(MainActivity.this,cust_id, cust_name, cust_mobile1,cust_mobile2,cust_address,cust_email);
        lisView.setAdapter(disadpt);
        Log.d("After", "SetAdapter");
        mCursor.close();
    }


	}
