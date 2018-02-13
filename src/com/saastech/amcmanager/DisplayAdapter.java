package com.saastech.amcmanager;

import java.util.ArrayList;

import com.saastech.amcmanager.DisplayAdapter.Holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DisplayAdapter extends BaseAdapter{
	
	    private Context mContext;
	    private ArrayList<String> cust_Id;
	    private ArrayList<String> cust_Name;
	    private ArrayList<String> cust_Mobile1;
	    private ArrayList<String> cust_Mobile2;
	    private ArrayList<String> cust_Address;
	    private ArrayList<String> cust_Email;
	    
	public DisplayAdapter(Context c,ArrayList<String> cust_Id,ArrayList<String> cust_Name,ArrayList<String> cust_Mobile1,
			ArrayList<String> cust_Mobile2,ArrayList<String> cust_Adddress,ArrayList<String> cust_Email) 
	{
		// TODO Auto-generated constructor stub
		this.mContext=c;
		this.cust_Id=cust_Id;
		this.cust_Name=cust_Name;
		this.cust_Mobile1=cust_Mobile1;
		this.cust_Mobile2=cust_Mobile2;
		this.cust_Address=cust_Adddress;
		this.cust_Email=cust_Email;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return cust_Id.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return cust_Id.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View child, ViewGroup parent) {
		// TODO Auto-generated method stub
		Holder mHolder;
        LayoutInflater layoutInflater;
        if(child==null)
        {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.activity_display_customer_details, null);
            mHolder = new Holder();
            mHolder.cust_id=(TextView) child.findViewById(R.id.txtcustdid);
            mHolder.cust_name=(TextView) child.findViewById(R.id.txtcustdname);
            mHolder.cust_mobile1=(TextView) child.findViewById(R.id.txtcustdmobile1);
            mHolder.cust_mobile2=(TextView) child.findViewById(R.id.txtcustmobile2);
            mHolder.cust_address=(TextView) child.findViewById(R.id.txtcustdaddress);
            mHolder.cust_email=(TextView) child.findViewById(R.id.txtcustdemail);
            child.setTag(mHolder);
        }
        else 
        {
            mHolder = (Holder) child.getTag();
        }
        mHolder.cust_id.setText(cust_Id.get(position));
        mHolder.cust_name.setText(cust_Name.get(position));
        mHolder.cust_mobile1.setText(cust_Mobile1.get(position));
        mHolder.cust_mobile2.setText(cust_Mobile2.get(position));
        mHolder.cust_address.setText(cust_Address.get(position));
        mHolder.cust_email.setText(cust_Email.get(position));
		return child;
	}
	public class Holder
	{
		TextView cust_id;
		TextView cust_name;
		TextView cust_mobile1;
		TextView cust_mobile2;
		TextView cust_address;
		TextView cust_email;
	}

}
