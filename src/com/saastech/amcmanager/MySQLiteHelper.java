package com.saastech.amcmanager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    Context context;	
	// Database Version
	private static final int DATABASE_VERSION = 1;
   // Database Name
   private static final String DATABASE_NAME = "AMC_MANAGE_DB";
   public final static String TABLE_CUSTOMER = "customer";
   public static final String TABLE_SERVICE = "service";
   
   //Customer Table Variables
   public static final String CUST_ID = "_cid";
   public static final String CUST_NAME = "name";
   public static final String CUST_MOBILE_1 = "mobile_no1";
   public static final String CUST_MOBILE_2 = "mobile_no2";
   public static final String CUST_PHONE = "phone";
   public static final String CUST_ADDRESS = "address";
   public static final String CUST_EMAIL = "email";
   
 //Customer Table Variables 
   public static final String SERVICE_ID = "_sid";
   public static final String SERVICE_CUSTID = "_scid";
   public static final String SERVICE_REQ="service_req";
   public static final String SERVICE_TYPE = "service_type";
   public static final String SERVICE_START_DATE= "service_start_date";
   public static final String SERVICE_RENIVAL_1="service_renival1";
   public static final String SERVICE_RENIVAL_2="service_renival2";
   public static final String SERVICE_RENIVAL_3="service_renival3";
   public static final String SERVICE_RENIVAL_4="service_renival4";
   public static final String SERVICE_RENIVAL_5="service_renival5";
   public static final String SERVICE_RENIVAL_6="service_renival6";
   public static final String SERVICE_RENIVAL_7="service_renival7";
   public static final String SERVICE_RENIVAL_8="service_renival8";
   public static final String SERVICE_RENIVAL_9="service_renival9";
   public static final String SERVICE_RENIVAL_10="service_renival10";
   public static final String SERVICE_RENIVAL_11="service_renival11";
   public static final String SERVICE_RENIVAL_12="service_renival12";
   public static final String SERVICE_MOBILE1="service_mobile1";
   public static final String SERVICE_EMAIL="service_email";
   
   //Date format
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   String date = sdf.format(new Date());
   

   //Create Customer Table
   private static final String CREATE_CUSTOMER_TABLE = "create table "
		      + TABLE_CUSTOMER 
		      + "(" 
		      + CUST_ID
		      + " integer primary key autoincrement NOT NULL , " 	      
		      + CUST_NAME
		      + " text not null NOT NULL, " 
		      + CUST_MOBILE_1
		      + " text NOT NULL, " 
		      + CUST_MOBILE_2 
		      + " text, " 
		      + CUST_PHONE 
		      + " text, " 
		      + CUST_ADDRESS 
		      + " text, " 
		      + CUST_EMAIL 
		      + " text NOT NULL "
		      + ");";
		      
  //Crete Service Table
   private static final String CREATE_SERVICE_TABLE = "create table "
		      + TABLE_SERVICE 
		      + "(" 
		      + SERVICE_ID
		      + " integer primary key autoincrement, " 
		      + SERVICE_CUSTID
		      + " integer, " 
		      + SERVICE_REQ
		      + " text, " 
		      + SERVICE_TYPE
		      + " text, " 
		      + SERVICE_START_DATE
		      + " TIMERS, " 
		      + SERVICE_RENIVAL_1 
		      + " TIMERS, " 
		      + SERVICE_RENIVAL_2 
		      + " TIMERS, "
		      + SERVICE_RENIVAL_3 
		      + " TIMERS, "
		      + SERVICE_RENIVAL_4 
		      + " TIMERS, "
		      + SERVICE_RENIVAL_5 
		      + " TIMERS, "
		      + SERVICE_RENIVAL_6
		      + " TIMERS, "
		      + SERVICE_RENIVAL_7 
		      + " TIMERS, "
		      + SERVICE_RENIVAL_8 
		      + " TIMERS, "
		      + SERVICE_RENIVAL_9 
		      + " TIMERS, "
		      + SERVICE_RENIVAL_10 
		      + " TIMERS, "
		      + SERVICE_RENIVAL_11 
		      + " TIMERS, "
		      + SERVICE_RENIVAL_12 
		      + " TIMERS, "
		      + SERVICE_MOBILE1 
		      + " text, "
		      + SERVICE_EMAIL 
		      + " text, "
		      + " FOREIGN KEY ( " + SERVICE_CUSTID + " ) REFERENCES " + TABLE_CUSTOMER + " ( " + CUST_ID + " )" + ");";
		     

   public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}

   
   //Search Query 
   
	@Override
	public void onCreate(SQLiteDatabase db) {
		// Customer Auto-generated method stub
		// SQL statement to create book table
		db.execSQL(CREATE_CUSTOMER_TABLE);
		db.execSQL(CREATE_SERVICE_TABLE);
		}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Customer Auto-generated method stub
		// on upgrade drop older tables
				db.execSQL("DROP TABLE IF EXISTS " + CREATE_CUSTOMER_TABLE);
				db.execSQL("DROP TABLE IF EXISTS " + CREATE_SERVICE_TABLE);
				this.onCreate(db);	
	      }
	/*
	 * Creating tag
	 */
	public long addCustomer(Customer cust) {
	     SQLiteDatabase db = this.getWritableDatabase();
	      ContentValues values = new ContentValues();
	      values.put(CUST_NAME,cust.getCustName() );
	      values.put(CUST_MOBILE_1, cust.getCustMobileno1());
	      values.put(CUST_MOBILE_2, cust.getCustMobileno2());
	      values.put(CUST_PHONE, cust.getCustPhone());
	      values.put(CUST_ADDRESS, cust.getCustAddress());
	      values.put(CUST_EMAIL, cust.getCustEmail());
	      // insert row
	      long cust_id = db.insert(TABLE_CUSTOMER, null, values);
	      return cust_id;
	}
	
	/*
	 * Creating tag
	 */
	public long addService(Service serv) {
	     SQLiteDatabase db = this.getWritableDatabase();
	      ContentValues values = new ContentValues();
	      values.put(SERVICE_CUSTID,serv.getServCustId());
	      values.put(SERVICE_REQ,serv.getServReq());
	      values.put(SERVICE_TYPE, serv.getServCustType());
	      values.put(SERVICE_START_DATE,serv.getServStartDate());
	      values.put(SERVICE_RENIVAL_1,serv.getServRenewal1());
	      values.put(SERVICE_RENIVAL_2, serv.getServRenewal2());
	      values.put(SERVICE_RENIVAL_3, serv.getServRenewal3());
	      values.put(SERVICE_RENIVAL_4, serv.getServRenewal4());
	      values.put(SERVICE_RENIVAL_5, serv.getServRenewal5());
	      values.put(SERVICE_RENIVAL_6, serv.getServRenewal6());
	      values.put(SERVICE_RENIVAL_7, serv.getServRenewal7());
	      values.put(SERVICE_RENIVAL_8, serv.getServRenewal8());
	      values.put(SERVICE_RENIVAL_9, serv.getServRenewal9());
	      values.put(SERVICE_RENIVAL_10, serv.getServRenewal10());
	      values.put(SERVICE_RENIVAL_11, serv.getServRenewal11());
	      values.put(SERVICE_RENIVAL_12, serv.getServRenewal12());
	      values.put(SERVICE_MOBILE1,serv.getServMobile1());
	      values.put(SERVICE_EMAIL, serv.getServEmail());
	      // insert row
	      long cust_id = db.insert(TABLE_SERVICE, null, values);
	      return cust_id;
	}
	/*
	 * Deleting a todo
	 */
	public void deleteCustomer(long Cust_id) {
	    SQLiteDatabase db = this.getWritableDatabase();
	    db.delete(TABLE_CUSTOMER, CUST_ID + " = ?",
        new String[] { String.valueOf(Cust_id) });
	}
	
	
	/*
	 * getting all todos
	 * */
	public List<Customer> getAllCustomeList() {
	    List<Customer> custm = new ArrayList<Customer>();
	    String selectQuery = " SELECT * FROM " + TABLE_CUSTOMER;
	    Log.e("DisPlay Values", selectQuery);
	     SQLiteDatabase db = this.getReadableDatabase();
         Cursor c = db.rawQuery(selectQuery, null);
	    // looping through all rows and adding to list
	   if (c.moveToFirst()) {
		   do {
	           Customer Cust = new Customer();
	           Cust.setCustId(c.getInt((c.getColumnIndex(CUST_ID))));
	           Cust.setCustName((c.getString(c.getColumnIndex(CUST_NAME))));
	           Cust.setCustMobileno1(c.getString(c.getColumnIndex(CUST_MOBILE_1)));
	           Cust.setCustMobileno2(c.getString(c.getColumnIndex(CUST_MOBILE_2)));
	           Cust.setCusPhone(c.getString(c.getColumnIndex(CUST_PHONE)));
	           Cust.setCustAddress(c.getString(c.getColumnIndex(CUST_ADDRESS)));
	           Cust.setCustEmail(c.getString(c.getColumnIndex(CUST_EMAIL)));
	           // adding to todo list
	           custm.add(Cust);
	         } while (c.moveToNext());       
	    }
	   return custm;
	}

	public List<Service> getAllContacts2() {
		List<Service> contactList = new ArrayList<Service>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_SERVICE + " where " + SERVICE_TYPE + "= 'FortNightly'";

		//SQLiteDatabase db = this.getWritableDatabase();
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Service service1 = new Service();
			     service1.setServCustId(cursor.getInt(1));
				 service1.setServReq(cursor.getString(2));
				 service1.setServType(cursor.getString(3));
				 service1.setServStartDate(cursor.getString(4));
				 service1.setServRenewal1(cursor.getString(5));
				 service1.setServRenewal2(cursor.getString(6));
				 service1.setServRenewal3(cursor.getString(7));
				 service1.setServRenewal4(cursor.getString(8));
				 service1.setServRenewal5(cursor.getString(9));
				 service1.setServRenewal6(cursor.getString(10));
				 service1.setServRenewal7(cursor.getString(11));
				 service1.setServRenewal8(cursor.getString(12));
				 service1.setServRenewal9(cursor.getString(13));
				 service1.setServRenewal10(cursor.getString(14));
				 service1.setServRenewal11(cursor.getString(15));
				 service1.setServRenewal12(cursor.getString(16));
				 service1.setServMobile1(cursor.getString(17));
				 service1.setServEmail(cursor.getString(18));
				 // Adding contact to list
				contactList.add(service1);
			} while (cursor.moveToNext());
		}

		// return contact list
		return contactList;
	}

	public List<Service> getAllContacts1() {
		List<Service> contactList = new ArrayList<Service>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_SERVICE + " where " + SERVICE_TYPE + "= 'Weekly'";

		//SQLiteDatabase db = this.getWritableDatabase();
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Service service1 = new Service();
			     service1.setServCustId(cursor.getInt(1));
				 service1.setServReq(cursor.getString(2));
				 service1.setServType(cursor.getString(3));
				 service1.setServStartDate(cursor.getString(4));
				 service1.setServRenewal1(cursor.getString(5));
				 service1.setServRenewal2(cursor.getString(6));
				 service1.setServRenewal3(cursor.getString(7));
				 service1.setServRenewal4(cursor.getString(8));
				 service1.setServRenewal5(cursor.getString(9));
				 service1.setServRenewal6(cursor.getString(10));
				 service1.setServRenewal7(cursor.getString(11));
				 service1.setServRenewal8(cursor.getString(12));
				 service1.setServRenewal9(cursor.getString(13));
				 service1.setServRenewal10(cursor.getString(14));
				 service1.setServRenewal11(cursor.getString(15));
				 service1.setServRenewal12(cursor.getString(16));
				 service1.setServMobile1(cursor.getString(17));
				 service1.setServEmail(cursor.getString(18));
				 // Adding contact to list
				contactList.add(service1);
			} while (cursor.moveToNext());
		}

		// return contact list
		return contactList;
	}

	public List<Service> getAllContacts3() {
		List<Service> contactList = new ArrayList<Service>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_SERVICE + " where " + SERVICE_TYPE + "= 'Monthly'";

		//SQLiteDatabase db = this.getWritableDatabase();
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Service service1 = new Service();
			     service1.setServCustId(cursor.getInt(1));
				 service1.setServReq(cursor.getString(2));
				 service1.setServType(cursor.getString(3));
				 service1.setServStartDate(cursor.getString(4));
				 service1.setServRenewal1(cursor.getString(5));
				 service1.setServRenewal2(cursor.getString(6));
				 service1.setServRenewal3(cursor.getString(7));
				 service1.setServRenewal4(cursor.getString(8));
				 service1.setServRenewal5(cursor.getString(9));
				 service1.setServRenewal6(cursor.getString(10));
				 service1.setServRenewal7(cursor.getString(11));
				 service1.setServRenewal8(cursor.getString(12));
				 service1.setServRenewal9(cursor.getString(13));
				 service1.setServRenewal10(cursor.getString(14));
				 service1.setServRenewal11(cursor.getString(15));
				 service1.setServRenewal12(cursor.getString(16));
				 service1.setServMobile1(cursor.getString(17));
				 service1.setServEmail(cursor.getString(18));
				 // Adding contact to list
				contactList.add(service1);
			} while (cursor.moveToNext());
		}

		// return contact list
		return contactList;
	}

	public List<Service> getAllContacts4() {
		List<Service> contactList = new ArrayList<Service>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_SERVICE + " where " + SERVICE_TYPE + "= 'Quarterly'";

		//SQLiteDatabase db = this.getWritableDatabase();
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Service service1 = new Service();
			     service1.setServCustId(cursor.getInt(1));
				 service1.setServReq(cursor.getString(2));
				 service1.setServType(cursor.getString(3));
				 service1.setServStartDate(cursor.getString(4));
				 service1.setServRenewal1(cursor.getString(5));
				 service1.setServRenewal2(cursor.getString(6));
				 service1.setServRenewal3(cursor.getString(7));
				 service1.setServRenewal4(cursor.getString(8));
				 service1.setServRenewal5(cursor.getString(9));
				 service1.setServRenewal6(cursor.getString(10));
				 service1.setServRenewal7(cursor.getString(11));
				 service1.setServRenewal8(cursor.getString(12));
				 service1.setServRenewal9(cursor.getString(13));
				 service1.setServRenewal10(cursor.getString(14));
				 service1.setServRenewal11(cursor.getString(15));
				 service1.setServRenewal12(cursor.getString(16));
				 service1.setServMobile1(cursor.getString(17));
				 service1.setServEmail(cursor.getString(18));
				 // Adding contact to list
				contactList.add(service1);
			} while (cursor.moveToNext());
		}

		// return contact list
		return contactList;
	}

	public List<Service> getAllContacts5() {
		List<Service> contactList = new ArrayList<Service>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_SERVICE + " where " + SERVICE_TYPE + "= 'HalfYearly'";

		//SQLiteDatabase db = this.getWritableDatabase();
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Service service1 = new Service();
			     service1.setServCustId(cursor.getInt(1));
				 service1.setServReq(cursor.getString(2));
				 service1.setServType(cursor.getString(3));
				 service1.setServStartDate(cursor.getString(4));
				 service1.setServRenewal1(cursor.getString(5));
				 service1.setServRenewal2(cursor.getString(6));
				 service1.setServRenewal3(cursor.getString(7));
				 service1.setServRenewal4(cursor.getString(8));
				 service1.setServRenewal5(cursor.getString(9));
				 service1.setServRenewal6(cursor.getString(10));
				 service1.setServRenewal7(cursor.getString(11));
				 service1.setServRenewal8(cursor.getString(12));
				 service1.setServRenewal9(cursor.getString(13));
				 service1.setServRenewal10(cursor.getString(14));
				 service1.setServRenewal11(cursor.getString(15));
				 service1.setServRenewal12(cursor.getString(16));
				 service1.setServMobile1(cursor.getString(17));
				 service1.setServEmail(cursor.getString(18));
				 // Adding contact to list
				contactList.add(service1);
			} while (cursor.moveToNext());
		}

		// return contact list
		return contactList;
	}
	public List<Service> getAllContacts6() {
		List<Service> contactList = new ArrayList<Service>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_SERVICE + " where " + SERVICE_TYPE + "= 'Yearly'";

		//SQLiteDatabase db = this.getWritableDatabase();
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Service service1 = new Service();
			     service1.setServCustId(cursor.getInt(1));
				 service1.setServReq(cursor.getString(2));
				 service1.setServType(cursor.getString(3));
				 service1.setServStartDate(cursor.getString(4));
				 service1.setServRenewal1(cursor.getString(5));
				 service1.setServRenewal2(cursor.getString(6));
				 service1.setServRenewal3(cursor.getString(7));
				 service1.setServRenewal4(cursor.getString(8));
				 service1.setServRenewal5(cursor.getString(9));
				 service1.setServRenewal6(cursor.getString(10));
				 service1.setServRenewal7(cursor.getString(11));
				 service1.setServRenewal8(cursor.getString(12));
				 service1.setServRenewal9(cursor.getString(13));
				 service1.setServRenewal10(cursor.getString(14));
				 service1.setServRenewal11(cursor.getString(15));
				 service1.setServRenewal12(cursor.getString(16));
				 service1.setServMobile1(cursor.getString(17));
				 service1.setServEmail(cursor.getString(18));
				 // Adding contact to list
				contactList.add(service1);
			} while (cursor.moveToNext());
		}

		// return contact list
		return contactList;
	}


	public Cursor rawQuery(String str, Object object) {
		// TODO Auto-generated method stub
		return null;
	} 
	
}
