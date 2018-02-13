package com.saastech.amcmanager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.telephony.gsm.SmsManager;
import android.text.format.DateUtils;
import android.text.method.DateTimeKeyListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddNewCustomer extends Activity {
	Customer customer;
	Service service;
	ListView lisView;
	TextView cname,cmobile1,cmobile2,cphone,caddress,cemail,sservice,type,txtsdate;
	EditText ecname,ecmobile1,ecmobile2,ecphone,ecaddress,ecemail,etxtsservice,etxtdate;
	Button cbclean,cbsave,cbcancel;
	Spinner spinner;
	String scname,scmobile1,scmobile2,scphone,scaddress,scemail,scsService,scsdate,sctype,scsmobile1,scsemail;
	 MySQLiteHelper db;
	 //today's date in format "YYYY-MM-DD"
	    DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date todaysDate =Calendar.getInstance().getTime();
		String formattedDate=df.format(todaysDate);
		final String finalTodaysDate=formattedDate.substring(0,10);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_customer);

		//create customer object
	    customer=new Customer();
	    
	    //create service object
	    service=new Service();
	    
		//create db object 
	    db = new MySQLiteHelper(this);
	    
	  		//edittext
	  		ecname=(EditText) findViewById(R.id.etxtcname);
	  		ecmobile1=(EditText) findViewById(R.id.etxtmobile1);
	  		ecmobile2=(EditText) findViewById(R.id.etxtmobile2);
	  		ecphone=(EditText) findViewById(R.id.etxtphone);
	  		ecaddress=(EditText) findViewById(R.id.etxtaddress);
	  		ecemail=(EditText) findViewById(R.id.etxtemail);
	  		etxtsservice=(EditText) findViewById(R.id.etxtservice);
	  		etxtdate=(EditText) findViewById(R.id.etxtsdate);
	  		etxtdate.setText(finalTodaysDate);
	  	
	  		
	  		//spinner create
	  		spinner=(Spinner) findViewById(R.id.spinner1);
	  		addItemsToReminderTypeSpinner();
	  		
	  		//button
	  		cbcancel=(Button) findViewById(R.id.bccancel);
	  		cbclean=(Button) findViewById(R.id.bcclear);
	  		cbsave=(Button) findViewById(R.id.bcsave);
	  		
	  		cbsave.setOnClickListener(new OnClickListener() {
	  			
	  			@Override
	  			public void onClick(View v) {
	  				// TODO Auto-generated method stub
	  				int inserted_cust_id=customeradd();
	  				//serviceadd(inserted_cust_id,finalTodaysDate);
	  				String remiderType=spinner.getSelectedItem().toString().trim();
	  				
	  				if(remiderType.equals("-= Select Report Type =-"))
	  					Toast.makeText(getApplicationContext(), "Please select remider type!!", 1).show();
	  				else
	  					addNewServiceToDb(remiderType,inserted_cust_id);
	  				
	  			}
	  		});
	  		
	  		cbcancel.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				 //finish();			
					getWeeklyValues();
					getFortNightlyValues();
					getMonthlyValues();
					getQuarterlyValues();
					getHalfYearlyValues();
					getYearlyValues();
					//Toast.makeText(getApplicationContext(), str, 1).show();	
					
				}
			});
	  		
        
	  		cbclean.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					ecname.setText("");
	  				ecmobile1.setText("");
	  				ecmobile2.setText(" ");
	  				ecphone.setText("");
	  				ecaddress.setText("");
	  				ecemail.setText("");
	  				etxtsservice.setText("");
	  				ecname.requestFocus();
				}
			});

	}
	
	//Finding Week dates method
	public void  getWeeklyValues() {
		    
	        String str="SELECT * FROM " + db.TABLE_SERVICE + " where " + db.SERVICE_TYPE + "= 'Weekly'";
	        MySQLiteHelper db = new MySQLiteHelper(this);
            List<Service> service1 = db.getAllContacts1();   
            
			for (Service sn1 : service1) {
				
				Log.d("FATCHING", "VALUES");
				Toast.makeText(getApplicationContext(), sn1.getServCustType(), 1).show();
				Log.d(sn1.getServRenewal1(), "1st Renival Date");
				Log.d(sn1.getServRenewal2(), "2nd Renival Date");
				Log.d(sn1.getServRenewal3(), "3rd Renival Date");
				Log.d(sn1.getServRenewal4(), "4th Renival Date");
				Log.d(sn1.getServRenewal5(), "5th Renival Date");
				Log.d(sn1.getServRenewal6(), "6th Renival Date");
				Log.d(sn1.getServRenewal7(), "7th Renival Date");
				Log.d(sn1.getServRenewal8(), "8th Renival Date");
				Log.d(sn1.getServRenewal9(), "9th Renival Date");
				Log.d(sn1.getServRenewal10(), "10th Renival Date");
				Log.d(sn1.getServRenewal11(), "11th Renival Date");
				Log.d(sn1.getServRenewal12(), "12th Renival Date");
				Log.d(sn1.getServMobile1(), "Mobile NUmber");
				Log.d(sn1.getServEmail(), "Email Id");
				Toast.makeText(getApplicationContext(), finalTodaysDate, 1).show();
				String phone,message;
				phone=sn1.getServMobile1();
				Toast.makeText(getApplicationContext(), sn1.getServMobile1(), 1).show();
				Toast.makeText(getApplicationContext(), sn1.getServReq(), 1).show();
				Toast.makeText(getApplicationContext(), sn1.getServEmail(), 1).show();
				message="Toady Last Day Reanival"+sn1.getServReq()+"Service";
				if(sn1.getServStartDate().equals(finalTodaysDate))
		           {
		        	 Log.d(sn1.getServRenewal1(), "1st Renival Date");
		        	 sendSMSMessage(phone,message);
			         Toast.makeText(getApplicationContext(), "Today Your Reanival day", Toast.LENGTH_LONG).show();
		           }
		    else
		     
				if(sn1.getServRenewal1().equals(finalTodaysDate))
			           {
			        	 Log.d(sn1.getServRenewal1(), "1st Renival Date");
			        	 sendSMSMessage(phone,message);
				         Toast.makeText(getApplicationContext(), "Today Your Reanival day", Toast.LENGTH_LONG).show();
			           }
			    else
			        if(sn1.getServRenewal2().equals(finalTodaysDate))
				      {
			        	Log.d(sn1.getServRenewal2(), "2nd Renival Date");
			        	sendSMSMessage(phone,message);
					   Toast.makeText(getApplicationContext(), "Today Your Reanival day", Toast.LENGTH_LONG).show();
				      }
			   else
					 if(sn1.getServRenewal3().equals(finalTodaysDate))
					   {   Log.d(sn1.getServRenewal3(), "3rd Renival Date");
					       sendSMSMessage(phone,message);
						   Toast.makeText(getApplicationContext(), "Today Your Reanival day", Toast.LENGTH_LONG).show();
					   }
				else
				     if(sn1.getServRenewal4().equals(finalTodaysDate))
					  {   Log.d(sn1.getServRenewal4(), "4th Renival Date");
					      sendSMSMessage(phone,message);
					     Toast.makeText(getApplicationContext(), "Today Your Reanival day", Toast.LENGTH_LONG).show();
					  }
			     else
					  if(sn1.getServRenewal5().equals(finalTodaysDate))
					   {   Log.d(sn1.getServRenewal5(), "5th Renival Date");
					       sendSMSMessage(phone,message);
			      		   Toast.makeText(getApplicationContext(), "Today Your Reanival day", Toast.LENGTH_LONG).show();
					  }
			     else
					if(sn1.getServRenewal6().equals(finalTodaysDate))
					   { Log.d(sn1.getServRenewal6(), "6th Renival Date");
					     sendSMSMessage(phone,message);
						 Toast.makeText(getApplicationContext(), "Today Your Reanival day", Toast.LENGTH_LONG).show();
					   }
			     else
				    if(sn1.getServRenewal7().equals(finalTodaysDate))
					  {  Log.d(sn1.getServRenewal7(), "7th Renival Date");
					     sendSMSMessage(phone,message);
						 Toast.makeText(getApplicationContext(), "Today Your Reanival day", Toast.LENGTH_LONG).show();
					  }
		         else
					 if(sn1.getServRenewal8().equals(finalTodaysDate))
					  {  Log.d(sn1.getServRenewal8(), "8th Renival Date");
					     sendSMSMessage(phone,message);
						 Toast.makeText(getApplicationContext(), "Today Your Reanival day", Toast.LENGTH_LONG).show();
					  }
			     else	     
				     if(sn1.getServRenewal9().equals(finalTodaysDate))
					  {  Log.d(sn1.getServRenewal9(), "9th Renival Date");
					     sendSMSMessage(phone,message);
						 Toast.makeText(getApplicationContext(), "Today Your Reanival day", Toast.LENGTH_LONG).show();
					  }
		         else	     
					 if(sn1.getServRenewal10().equals(finalTodaysDate))
					  {  Log.d(sn1.getServRenewal10(), "10th Renival Date");
					     sendSMSMessage(phone,message);
						 Toast.makeText(getApplicationContext(), "Today Your Reanival day", Toast.LENGTH_LONG).show();
					  }
				 else	     
					if(sn1.getServRenewal11().equals(finalTodaysDate))
					  {  Log.d(sn1.getServRenewal11(), "11th Renival Date");
					     sendSMSMessage(phone,message);
						 Toast.makeText(getApplicationContext(), "Today Your Reanival day", Toast.LENGTH_LONG).show();
					  }
			     else	     
					 if(sn1.getServRenewal2().equals(finalTodaysDate))
					   {   Log.d(sn1.getServRenewal12(), "12th Renival Date");
					       sendSMSMessage(phone,message);
					       Toast.makeText(getApplicationContext(), "Today Your Reanival day", Toast.LENGTH_LONG).show();
					   }
				
					 else
				      {
					    if( sn1.getServRenewal1().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal2().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal3().equals(addDaysToCurrentDate(-2)) ||
					    	sn1.getServRenewal4().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal5().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal6().equals(addDaysToCurrentDate(-2)) ||	
					       sn1.getServRenewal7().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal8().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal9().equals(addDaysToCurrentDate(-2)) ||
					       sn1.getServRenewal10().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal11().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal12().equals(addDaysToCurrentDate(-2)))
					    		{
					    	        sendSMSMessage(phone,message);
						             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
					    		}
					    
					    else
					       {
						      if( sn1.getServRenewal1().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal2().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal3().equals(addDaysToCurrentDate(2)) ||
						    	  sn1.getServRenewal4().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal5().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal6().equals(addDaysToCurrentDate(2)) ||	
						          sn1.getServRenewal7().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal8().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal9().equals(addDaysToCurrentDate(2)) ||
						         sn1.getServRenewal10().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal11().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal12().equals(addDaysToCurrentDate(2)))
						    		{
						    	        sendSMSMessage(phone,message);
							             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
						    		}
						      else
						        { Toast.makeText(getApplicationContext(), "Weekly Renival Future Date"+sn1.getServStartDate(), 1).show();}
				     
					         }
				      }
				      
				   }
				
	}
	
	//Finding 15 days dates method
		public void  getFortNightlyValues() {
			    
		        String str="SELECT * FROM " + db.TABLE_SERVICE + " where " + db.SERVICE_TYPE + "= 'FortNightly'";
		        MySQLiteHelper db = new MySQLiteHelper(this);
	            List<Service> service1 = db.getAllContacts2();   
	            
				for (Service sn1 : service1) {
					
					Log.d("FATCHING", "VALUES");
					Toast.makeText(getApplicationContext(), sn1.getServCustType(), 1).show();
					Log.d(sn1.getServRenewal1(), "1st Renival Date");
					Log.d(sn1.getServRenewal2(), "2nd Renival Date");
					Log.d(sn1.getServRenewal3(), "3rd Renival Date");
					Log.d(sn1.getServRenewal4(), "4th Renival Date");
					Log.d(sn1.getServRenewal5(), "5th Renival Date");
					Log.d(sn1.getServRenewal6(), "6th Renival Date");
					Log.d(sn1.getServRenewal7(), "7th Renival Date");
					Log.d(sn1.getServRenewal8(), "8th Renival Date");
					Log.d(sn1.getServRenewal9(), "9th Renival Date");
					Log.d(sn1.getServRenewal10(), "10th Renival Date");
					Log.d(sn1.getServRenewal11(), "11th Renival Date");
					Log.d(sn1.getServRenewal12(), "12th Renival Date");
					Log.d(sn1.getServMobile1(), "Mobile NUmber");
					Log.d(sn1.getServEmail(), "Email Id");
					Toast.makeText(getApplicationContext(), finalTodaysDate, 1).show();
					String phone,message;
					phone=sn1.getServMobile1();
					Toast.makeText(getApplicationContext(), sn1.getServMobile1(), 1).show();
					Toast.makeText(getApplicationContext(), sn1.getServReq(), 1).show();
					message="Toady Last Day Reanival"+sn1.getServReq()+"Service";
					
		              {
						    if( sn1.getServRenewal1().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal2().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal3().equals(addDaysToCurrentDate(-2)) ||
						    	sn1.getServRenewal4().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal5().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal6().equals(addDaysToCurrentDate(-2)) ||	
						        sn1.getServRenewal7().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal8().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal9().equals(addDaysToCurrentDate(-2)) ||
						       sn1.getServRenewal10().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal11().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal12().equals(addDaysToCurrentDate(-2)))
						    		{
						    	        sendSMSMessage(phone,message);
							             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
						    		}
						 else
							      if( sn1.getServRenewal1().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal2().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal3().equals(addDaysToCurrentDate(2)) ||
							    	  sn1.getServRenewal4().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal5().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal6().equals(addDaysToCurrentDate(2)) ||	
							          sn1.getServRenewal7().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal8().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal9().equals(addDaysToCurrentDate(2)) ||
							         sn1.getServRenewal10().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal11().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal12().equals(addDaysToCurrentDate(2)))
							    		{
							    	        sendSMSMessage(phone,message);
								             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
							    		}
							  else    
								  if(sn1.getServStartDate().equals(finalTodaysDate) || sn1.getServRenewal1().equals(finalTodaysDate) || sn1.getServRenewal2().equals(finalTodaysDate) || sn1.getServRenewal3().equals(finalTodaysDate) ||
									 sn1.getServRenewal4().equals(finalTodaysDate) || sn1.getServRenewal5().equals(finalTodaysDate) || sn1.getServRenewal6().equals(finalTodaysDate) ||	
									 sn1.getServRenewal7().equals(finalTodaysDate) || sn1.getServRenewal8().equals(finalTodaysDate) || sn1.getServRenewal9().equals(finalTodaysDate) ||
								     sn1.getServRenewal10().equals(finalTodaysDate) || sn1.getServRenewal11().equals(finalTodaysDate) || sn1.getServRenewal12().equals(finalTodaysDate))
								     {
									     sendSMSMessage(phone,message);
							             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
						    		
								     }
							else
							        { Toast.makeText(getApplicationContext(), "FortNightly Renival Future Date"+sn1.getServStartDate(), 1).show();}
					      }
					   }
		}
	
		//Finding Monthly dates method
				public void  getMonthlyValues() {
					    
				        String str="SELECT * FROM " + db.TABLE_SERVICE + " where " + db.SERVICE_TYPE + "= 'Monthly'";
				        MySQLiteHelper db = new MySQLiteHelper(this);
			            List<Service> service1 = db.getAllContacts3();   
			            
						for (Service sn1 : service1) {
							
							Log.d("FATCHING", "VALUES");
							Toast.makeText(getApplicationContext(), sn1.getServCustType(), 1).show();
							Log.d(sn1.getServRenewal1(), "1st Renival Date");
							Log.d(sn1.getServRenewal2(), "2nd Renival Date");
							Log.d(sn1.getServRenewal3(), "3rd Renival Date");
							Log.d(sn1.getServRenewal4(), "4th Renival Date");
							Log.d(sn1.getServRenewal5(), "5th Renival Date");
							Log.d(sn1.getServRenewal6(), "6th Renival Date");
							Log.d(sn1.getServRenewal7(), "7th Renival Date");
							Log.d(sn1.getServRenewal8(), "8th Renival Date");
							Log.d(sn1.getServRenewal9(), "9th Renival Date");
							Log.d(sn1.getServRenewal10(), "10th Renival Date");
							Log.d(sn1.getServRenewal11(), "11th Renival Date");
							Log.d(sn1.getServRenewal12(), "12th Renival Date");
							Log.d(sn1.getServMobile1(), "Mobile NUmber");
							Log.d(sn1.getServEmail(), "Email Id");
							Toast.makeText(getApplicationContext(), finalTodaysDate, 1).show();
							String phone,message;
							phone=sn1.getServMobile1();
							Toast.makeText(getApplicationContext(), sn1.getServMobile1(), 1).show();
							Toast.makeText(getApplicationContext(), sn1.getServReq(), 1).show();
							message="Toady Last Day Reanival"+sn1.getServReq()+"Service";
							
				              {
								    if( sn1.getServRenewal1().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal2().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal3().equals(addDaysToCurrentDate(-2)) ||
								    	sn1.getServRenewal4().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal5().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal6().equals(addDaysToCurrentDate(-2)) ||	
								        sn1.getServRenewal7().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal8().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal9().equals(addDaysToCurrentDate(-2)) ||
								       sn1.getServRenewal10().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal11().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal12().equals(addDaysToCurrentDate(-2)))
								    		{
								    	        sendSMSMessage(phone,message);
									             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
								    		}
								 else
									      if( sn1.getServRenewal1().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal2().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal3().equals(addDaysToCurrentDate(2)) ||
									    	  sn1.getServRenewal4().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal5().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal6().equals(addDaysToCurrentDate(2)) ||	
									          sn1.getServRenewal7().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal8().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal9().equals(addDaysToCurrentDate(2)) ||
									         sn1.getServRenewal10().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal11().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal12().equals(addDaysToCurrentDate(2)))
									    		{
									    	        sendSMSMessage(phone,message);
										             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
									    		}
									  else    
										  if(sn1.getServStartDate().equals(finalTodaysDate) || sn1.getServRenewal1().equals(finalTodaysDate) || sn1.getServRenewal2().equals(finalTodaysDate) || sn1.getServRenewal3().equals(finalTodaysDate) ||
											 sn1.getServRenewal4().equals(finalTodaysDate) || sn1.getServRenewal5().equals(finalTodaysDate) || sn1.getServRenewal6().equals(finalTodaysDate) ||	
											 sn1.getServRenewal7().equals(finalTodaysDate) || sn1.getServRenewal8().equals(finalTodaysDate) || sn1.getServRenewal9().equals(finalTodaysDate) ||
										     sn1.getServRenewal10().equals(finalTodaysDate) || sn1.getServRenewal11().equals(finalTodaysDate) || sn1.getServRenewal12().equals(finalTodaysDate))
										     {
											     sendSMSMessage(phone,message);
									             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
								    		
										     }
									else
									{ Toast.makeText(getApplicationContext(), "Monthly Renival Future Date"+sn1.getServStartDate(), Toast.LENGTH_LONG).show();}
							      }
							   }
				}
		
				//Finding Quarterly dates method
				public void  getQuarterlyValues() {
					    
				        String str="SELECT * FROM " + db.TABLE_SERVICE + " where " + db.SERVICE_TYPE + "= 'Quarterly'";
				        MySQLiteHelper db = new MySQLiteHelper(this);
			            List<Service> service1 = db.getAllContacts4();   
			            
						for (Service sn1 : service1) {
							
							Log.d("FATCHING", "VALUES");
							Toast.makeText(getApplicationContext(), sn1.getServCustType(), 1).show();
							Log.d(sn1.getServRenewal1(), "1st Renival Date");
							Log.d(sn1.getServRenewal2(), "2nd Renival Date");
							Log.d(sn1.getServRenewal3(), "3rd Renival Date");
							Log.d(sn1.getServRenewal4(), "4th Renival Date");
							Log.d(sn1.getServRenewal5(), "5th Renival Date");
							Log.d(sn1.getServRenewal6(), "6th Renival Date");
							Log.d(sn1.getServRenewal7(), "7th Renival Date");
							Log.d(sn1.getServRenewal8(), "8th Renival Date");
							Log.d(sn1.getServRenewal9(), "9th Renival Date");
							Log.d(sn1.getServRenewal10(), "10th Renival Date");
							Log.d(sn1.getServRenewal11(), "11th Renival Date");
							Log.d(sn1.getServRenewal12(), "12th Renival Date");
							Log.d(sn1.getServMobile1(), "Mobile NUmber");
							Log.d(sn1.getServEmail(), "Email Id");
							Toast.makeText(getApplicationContext(), finalTodaysDate, 1).show();
							String phone,message;
							phone=sn1.getServMobile1();
							Toast.makeText(getApplicationContext(), sn1.getServMobile1(), 1).show();
							Toast.makeText(getApplicationContext(), sn1.getServReq(), 1).show();
							message="Toady Last Day Reanival"+sn1.getServReq()+"Service";
							
				              {
								    if( sn1.getServRenewal1().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal2().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal3().equals(addDaysToCurrentDate(-2)) ||
								    	sn1.getServRenewal4().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal5().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal6().equals(addDaysToCurrentDate(-2)) ||	
								        sn1.getServRenewal7().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal8().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal9().equals(addDaysToCurrentDate(-2)) ||
								       sn1.getServRenewal10().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal11().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal12().equals(addDaysToCurrentDate(-2)))
								    		{
								    	        sendSMSMessage(phone,message);
									             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
								    		}
								 else
									      if( sn1.getServRenewal1().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal2().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal3().equals(addDaysToCurrentDate(2)) ||
									    	  sn1.getServRenewal4().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal5().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal6().equals(addDaysToCurrentDate(2)) ||	
									          sn1.getServRenewal7().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal8().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal9().equals(addDaysToCurrentDate(2)) ||
									         sn1.getServRenewal10().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal11().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal12().equals(addDaysToCurrentDate(2)))
									    		{
									    	        sendSMSMessage(phone,message);
										             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
									    		}
									  else    
										  if(sn1.getServRenewal1().equals(finalTodaysDate) || sn1.getServRenewal2().equals(finalTodaysDate) || sn1.getServRenewal3().equals(finalTodaysDate) ||
											 sn1.getServRenewal4().equals(finalTodaysDate) || sn1.getServRenewal5().equals(finalTodaysDate) || sn1.getServRenewal6().equals(finalTodaysDate) ||	
											 sn1.getServRenewal7().equals(finalTodaysDate) || sn1.getServRenewal8().equals(finalTodaysDate) || sn1.getServRenewal9().equals(finalTodaysDate) ||
										     sn1.getServRenewal10().equals(finalTodaysDate) || sn1.getServRenewal11().equals(finalTodaysDate) || sn1.getServRenewal12().equals(finalTodaysDate))
										     {
											     sendSMSMessage(phone,message);
									             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
								    		
										     }
										  else
											{ Toast.makeText(getApplicationContext(), "Quarterly Renival Future Date"+sn1.getServStartDate(), Toast.LENGTH_LONG).show();}
									     
							      }
							   }
				}
				
				
				//Finding HalfYearly dates method
				public void  getHalfYearlyValues() {
					    
				        String str="SELECT * FROM " + db.TABLE_SERVICE + " where " + db.SERVICE_TYPE + "= 'HalfYearly'";
				        MySQLiteHelper db = new MySQLiteHelper(this);
			            List<Service> service1 = db.getAllContacts5();   
			            
						for (Service sn1 : service1) {
							
							Log.d("FATCHING", "VALUES");
							Toast.makeText(getApplicationContext(), sn1.getServCustType(), 1).show();
							Log.d(sn1.getServRenewal1(), "1st Renival Date");
							Log.d(sn1.getServRenewal2(), "2nd Renival Date");
							Log.d(sn1.getServRenewal3(), "3rd Renival Date");
							Log.d(sn1.getServRenewal4(), "4th Renival Date");
							Log.d(sn1.getServRenewal5(), "5th Renival Date");
							Log.d(sn1.getServRenewal6(), "6th Renival Date");
							Log.d(sn1.getServRenewal7(), "7th Renival Date");
							Log.d(sn1.getServRenewal8(), "8th Renival Date");
							Log.d(sn1.getServRenewal9(), "9th Renival Date");
							Log.d(sn1.getServRenewal10(), "10th Renival Date");
							Log.d(sn1.getServRenewal11(), "11th Renival Date");
							Log.d(sn1.getServRenewal12(), "12th Renival Date");
							Log.d(sn1.getServMobile1(), "Mobile NUmber");
							Log.d(sn1.getServEmail(), "Email Id");
							Toast.makeText(getApplicationContext(), finalTodaysDate, 1).show();
							String phone,message;
							phone=sn1.getServMobile1();
							Toast.makeText(getApplicationContext(), sn1.getServMobile1(), 1).show();
							Toast.makeText(getApplicationContext(), sn1.getServReq(), 1).show();
							message="Toady Last Day Reanival"+sn1.getServReq()+"Service";
							
				              {
								    if( sn1.getServRenewal1().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal2().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal3().equals(addDaysToCurrentDate(-2)) ||
								    	sn1.getServRenewal4().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal5().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal6().equals(addDaysToCurrentDate(-2)) ||	
								        sn1.getServRenewal7().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal8().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal9().equals(addDaysToCurrentDate(-2)) ||
								       sn1.getServRenewal10().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal11().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal12().equals(addDaysToCurrentDate(-2)))
								    		{
								    	        sendSMSMessage(phone,message);
									             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
								    		}
								 else
									      if( sn1.getServRenewal1().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal2().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal3().equals(addDaysToCurrentDate(2)) ||
									    	  sn1.getServRenewal4().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal5().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal6().equals(addDaysToCurrentDate(2)) ||	
									          sn1.getServRenewal7().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal8().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal9().equals(addDaysToCurrentDate(2)) ||
									         sn1.getServRenewal10().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal11().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal12().equals(addDaysToCurrentDate(2)))
									    		{
									    	        sendSMSMessage(phone,message);
										             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
									    		}
									  else    
										  if(sn1.getServRenewal1().equals(finalTodaysDate) || sn1.getServRenewal2().equals(finalTodaysDate) || sn1.getServRenewal3().equals(finalTodaysDate) ||
											 sn1.getServRenewal4().equals(finalTodaysDate) || sn1.getServRenewal5().equals(finalTodaysDate) || sn1.getServRenewal6().equals(finalTodaysDate) ||	
											 sn1.getServRenewal7().equals(finalTodaysDate) || sn1.getServRenewal8().equals(finalTodaysDate) || sn1.getServRenewal9().equals(finalTodaysDate) ||
										     sn1.getServRenewal10().equals(finalTodaysDate) || sn1.getServRenewal11().equals(finalTodaysDate) || sn1.getServRenewal12().equals(finalTodaysDate))
										     {
											     sendSMSMessage(phone,message);
									             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
										     }
										  else
											{ Toast.makeText(getApplicationContext(), "HalfYearly Renival Future Date"+sn1.getServStartDate(), Toast.LENGTH_LONG).show();}
									    
							      }
							   }
				}
	
				//Finding HalfYearly dates method
				public void  getYearlyValues() {
					    
				        String str="SELECT * FROM " + db.TABLE_SERVICE + " where " + db.SERVICE_TYPE + "= 'Yearly'";
				        MySQLiteHelper db = new MySQLiteHelper(this);
			            List<Service> service1 = db.getAllContacts6();   
			            
						for (Service sn1 : service1) {
							
							Log.d("FATCHING", "VALUES");
							Toast.makeText(getApplicationContext(), sn1.getServCustType(), 1).show();
							Log.d(sn1.getServRenewal1(), "1st Renival Date");
							Log.d(sn1.getServRenewal2(), "2nd Renival Date");
							Log.d(sn1.getServRenewal3(), "3rd Renival Date");
							Log.d(sn1.getServRenewal4(), "4th Renival Date");
							Log.d(sn1.getServRenewal5(), "5th Renival Date");
							Log.d(sn1.getServRenewal6(), "6th Renival Date");
							Log.d(sn1.getServRenewal7(), "7th Renival Date");
							Log.d(sn1.getServRenewal8(), "8th Renival Date");
							Log.d(sn1.getServRenewal9(), "9th Renival Date");
							Log.d(sn1.getServRenewal10(), "10th Renival Date");
							Log.d(sn1.getServRenewal11(), "11th Renival Date");
							Log.d(sn1.getServRenewal12(), "12th Renival Date");
							Log.d(sn1.getServMobile1(), "Mobile NUmber");
							Log.d(sn1.getServEmail(), "Email Id");
							Toast.makeText(getApplicationContext(), finalTodaysDate, 1).show();
							String phone,message;
							phone=sn1.getServMobile1();
							Toast.makeText(getApplicationContext(), sn1.getServMobile1(), 1).show();
							Toast.makeText(getApplicationContext(), sn1.getServReq(), 1).show();
							message="Toady Last Day Reanival"+sn1.getServReq()+"Service";
							
				              {
								    if( sn1.getServRenewal1().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal2().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal3().equals(addDaysToCurrentDate(-2)) ||
								    	sn1.getServRenewal4().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal5().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal6().equals(addDaysToCurrentDate(-2)) ||	
								        sn1.getServRenewal7().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal8().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal9().equals(addDaysToCurrentDate(-2)) ||
								       sn1.getServRenewal10().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal11().equals(addDaysToCurrentDate(-2)) || sn1.getServRenewal12().equals(addDaysToCurrentDate(-2)))
								    		{
								    	        sendSMSMessage(phone,message);
									             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
								    		}
								 else
									      if( sn1.getServRenewal1().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal2().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal3().equals(addDaysToCurrentDate(2)) ||
									    	  sn1.getServRenewal4().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal5().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal6().equals(addDaysToCurrentDate(2)) ||	
									          sn1.getServRenewal7().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal8().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal9().equals(addDaysToCurrentDate(2)) ||
									         sn1.getServRenewal10().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal11().equals(addDaysToCurrentDate(2)) || sn1.getServRenewal12().equals(addDaysToCurrentDate(2)))
									    		{
									    	        sendSMSMessage(phone,message);
										             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
									    		}
									  else    
										  if(sn1.getServRenewal1().equals(finalTodaysDate) || sn1.getServRenewal2().equals(finalTodaysDate) || sn1.getServRenewal3().equals(finalTodaysDate) ||
											 sn1.getServRenewal4().equals(finalTodaysDate) || sn1.getServRenewal5().equals(finalTodaysDate) || sn1.getServRenewal6().equals(finalTodaysDate) ||	
											 sn1.getServRenewal7().equals(finalTodaysDate) || sn1.getServRenewal8().equals(finalTodaysDate) || sn1.getServRenewal9().equals(finalTodaysDate) ||
										     sn1.getServRenewal10().equals(finalTodaysDate) || sn1.getServRenewal11().equals(finalTodaysDate) || sn1.getServRenewal12().equals(finalTodaysDate))
										     {
											     sendSMSMessage(phone,message);
									             Toast.makeText(getApplicationContext(), "After Your Reanival day", Toast.LENGTH_LONG).show();
										     }
										  else
											{ Toast.makeText(getApplicationContext(), "Yearly Renival Future Date"+sn1.getServStartDate(), Toast.LENGTH_LONG).show();}
									    
							      }
							   }
				}
	
		
	//Adding Customer Details
  public int customeradd()
	{
		//get values from edittext
			scname=ecname.getText().toString();
			scmobile1=ecmobile1.getText().toString();
			scmobile2=ecmobile2.getText().toString();
			scphone=ecphone.getText().toString();
			scaddress=ecaddress.getText().toString();
			scemail=ecemail.getText().toString();
		     	customer.setCustName(scname);
				customer.setCustMobileno1(scmobile1);
				customer.setCustMobileno1(scmobile2);
				customer.setCusPhone(scphone);
				customer.setCustAddress(scaddress);
				customer.setCustEmail(scemail);
				long id=db.addCustomer(customer);
			int custid=Integer.parseInt(id+"");
			Toast.makeText(getApplicationContext(), "Customer id="+ custid, Toast.LENGTH_LONG).show();
			return custid;
			
	}
  
	//Adding Service Details
	public void serviceadd(int inserted_cust_id, String finalTodaysDate)
	{
		    scsService=etxtsservice.getText().toString();
			scsdate=etxtsservice.getText().toString();
			sctype=spinner.getSelectedItem().toString();
		    service.setServCustId(inserted_cust_id);
			service.setServReq(scsService);
			service.setServType(sctype);
			service.setServStartDate(scsdate);
			service.setServMobile1(scmobile1);
			service.setServEmail(scemail);
			db.addService(service);
			
	}
	
	public void addNewServiceToDb(String remiderType, int inserted_cust_id)
	{
		SQLiteDatabase databse= db.getWritableDatabase();
		scsService=etxtsservice.getText().toString();
		sctype=spinner.getSelectedItem().toString();
		scsdate=etxtdate.getText().toString();
		scsmobile1=ecmobile1.getText().toString();
		scsemail=ecemail.getText().toString();
		
		String insertRemiderQuery=null;
		
		if(remiderType.equals("Weekly")){
			insertRemiderQuery="insert into "+ MySQLiteHelper.TABLE_SERVICE 
								+ " values( null, " 
								+ inserted_cust_id + " , '" 
								+ scsService + "', '" 
								+ sctype + "', '"
								+ scsdate + "', '" 
								+ addDaysToCurrentDate(7) + "', '" + addDaysToCurrentDate(14)+ "', '" + addDaysToCurrentDate(21) + "', '" + addDaysToCurrentDate(28) + "', '" + addDaysToCurrentDate(35) + "', '"
								+ addDaysToCurrentDate(42) + "', '" + addDaysToCurrentDate(49)+ "', '" + addDaysToCurrentDate(56) + "', '" + addDaysToCurrentDate(63) + "', '" + addDaysToCurrentDate(70) + "', '" +
                                 addDaysToCurrentDate(77) + "', '" + addDaysToCurrentDate(84)  + "', '" + scsmobile1 + "', '" + scsemail + "');";
	        	
		}
		else if(remiderType.equals("FortNightly")){
			insertRemiderQuery="insert into "+ MySQLiteHelper.TABLE_SERVICE 
					+ " values( null, "  
					+ inserted_cust_id + " , '" 
					+ scsService + "', '" 
					+ sctype + "', '"
					+ scsdate + "', '" 
					+ addDaysToCurrentDate(14) + "', '" + addDaysToCurrentDate(28)+ "', '" + addDaysToCurrentDate(42) + "', '" + addDaysToCurrentDate(56) + "', '" + addDaysToCurrentDate(70) + "', '"
					+ addDaysToCurrentDate(84) + "', '" + addDaysToCurrentDate(98)+ "', '" + addDaysToCurrentDate(112) + "', '" + addDaysToCurrentDate(126) + "', '" + addDaysToCurrentDate(140) + "', '" + addDaysToCurrentDate(154)
					+ "', '" + addDaysToCurrentDate(170) + "', '"  + scsmobile1 + "', '" + scsemail + "');";

		}
	    else if(remiderType.equals("Monthly")){
			insertRemiderQuery="insert into "+ MySQLiteHelper.TABLE_SERVICE 
					+ " values( null, "  
					+ inserted_cust_id + ", '" 
					+ scsService + "', '" 
					+ sctype + "', '"
					+ scsdate + "', '" 
					+ addMonthsToCurrentDate(1) + "', '" + addMonthsToCurrentDate(2)+ "', '" + addMonthsToCurrentDate(3) + "', '" + addMonthsToCurrentDate(4) + "', '" + addMonthsToCurrentDate(5)+ "', '"
					+ addMonthsToCurrentDate(6) + "', '" + addMonthsToCurrentDate(7)+ "', '" + addMonthsToCurrentDate(8) + "', '" + addMonthsToCurrentDate(9) + "', '" + addMonthsToCurrentDate(10) + "', '" + addMonthsToCurrentDate(11) 
					+ "', '" + addMonthsToCurrentDate(12) + "', '"  + scsmobile1 + "', '" + scsemail + "');";

		}
		else if(remiderType.equals("Quarterly")){
			insertRemiderQuery="insert into "+ MySQLiteHelper.TABLE_SERVICE 
					+ " values( null, "  
					+ inserted_cust_id + ", '" 
					+ scsService + "', '" 
					+ sctype + "', '"
					+ scsdate + "', '" 
					+ addMonthsToCurrentDate(3) + "', '" + addMonthsToCurrentDate(6) + "', '" + addMonthsToCurrentDate(9) + "', '" + addMonthsToCurrentDate(12) + "', '" + addMonthsToCurrentDate(15) + "', '"
					+ addMonthsToCurrentDate(18) + "', '" + addMonthsToCurrentDate(21) + "', '" + addMonthsToCurrentDate(24) + "', '" + addMonthsToCurrentDate(27) + "', '" + addMonthsToCurrentDate(30) + "', '" + addMonthsToCurrentDate(33) 
					+ "', '" + addMonthsToCurrentDate(36) + "', '" + scsmobile1 + "', '" + scsemail + "');";

		}else if(remiderType.equals("HalfYearly")){
			insertRemiderQuery="insert into "+ MySQLiteHelper.TABLE_SERVICE 
					+ " values( null, "  
					+ inserted_cust_id + ", '" 
					+ scsService + "', '" 
					+ sctype + "', '"
					+ scsdate + "', '" 
					+ addMonthsToCurrentDate(6) + "', '" + addMonthsToCurrentDate(12) + "', '" + addMonthsToCurrentDate(18) + "', '" + addMonthsToCurrentDate(24) + "', '" + addMonthsToCurrentDate(30) + "', '"
					+ addDaysToCurrentDate(36) + "', '" + addDaysToCurrentDate(42)+ "', '" + addDaysToCurrentDate(48) + "', '" + addMonthsToCurrentDate(54) + "', '" + addMonthsToCurrentDate(60) + "', '" + addMonthsToCurrentDate(66)
					+ "', '" + addMonthsToCurrentDate(72) + "', '"  + scsmobile1 + "', '" + scsemail + "');";

		}else if(remiderType.equals("Yearly")){
			insertRemiderQuery="insert into "+ MySQLiteHelper.TABLE_SERVICE 
					+ " values( null, "  
					+ inserted_cust_id + ", '" 
					+ scsService + "', '" 
					+ sctype + "', '"
					+ scsdate + "', '" 
					+ addYearsToCurrentDate(1) + "', '" + addYearsToCurrentDate(2) + "', '" + addYearsToCurrentDate(3) + "', '" + addYearsToCurrentDate(4) + "', '" + addYearsToCurrentDate(5) + "', '"
					+ addYearsToCurrentDate(6) + "', '" + addYearsToCurrentDate(7) + "', '" + addYearsToCurrentDate(8) + "', '" + addYearsToCurrentDate(9) + "', '" + addYearsToCurrentDate(10) + "', '" + addYearsToCurrentDate(11) 
					+ "', '" + addYearsToCurrentDate(12) + "', '"  + scsemail + "', '" + scsemail + "');";
       }
		
		Log.d("FinalQuery", insertRemiderQuery);
	    databse.execSQL(insertRemiderQuery);
		//databse.execSQL(insertRemiderQuery);
	}
	
	//This method use for ADDING Days
	public String addDaysToCurrentDate(int DaysToAdd){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, DaysToAdd); // Adding DaysToAdd days
		String newDate = sdf.format(c.getTime());
		//System.out.println(output);
		Log.d(newDate, "dateformat");
		return newDate;
	}
	
	//This method use for ADDING Months
	public String addMonthsToCurrentDate(int MonthsToAdd){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.MONTH, MonthsToAdd); // Adding DaysToAdd days
		String newMonth = sdf.format(c.getTime());
		//System.out.println(output);
		Log.d(newMonth, "dateformat");
		return newMonth;
	}
	
	//This method use for ADDING Years
	public String addYearsToCurrentDate(int YearsToAdd){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.YEAR, YearsToAdd); // Adding DaysToAdd days
		String newYear = sdf.format(c.getTime());
		//System.out.println(output);
		Log.d(newYear, "dateformat");
		return newYear;
	}
	
	  
	private void addItemsToReminderTypeSpinner() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
        list.add("-= Select Report Type =-");
        list.add("Weekly");
        list.add("FortNightly");
        list.add("Monthly");
        list.add("Quarterly");
        list.add("HalfYearly");
        list.add("Yearly");     
       // list.add("Custom");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                     (this, android.R.layout.simple_spinner_item,list);
                      
        dataAdapter.setDropDownViewResource
                     (android.R.layout.simple_spinner_dropdown_item);
                      
        spinner.setAdapter(dataAdapter);
	}
	
	
	public void sendSMSMessage(String phoneNo,String message) {
	      Log.i("Send SMS", "");
	      //String phoneno = null,message1 = null;
	       
	      try {
	         SmsManager smsManager = SmsManager.getDefault();
	         smsManager.sendTextMessage(phoneNo, null, message, null, null);
	         Toast.makeText(getApplicationContext(), "SMS sent.",
	         Toast.LENGTH_LONG).show();
	      } catch (Exception e) {
	         Toast.makeText(getApplicationContext(),
	         "SMS faild, please try again.",
	         Toast.LENGTH_LONG).show();
	         e.printStackTrace();
	      }
	   }
	
		@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_new_customer, menu);
		return true;
	}

}
