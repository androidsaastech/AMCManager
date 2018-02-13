package com.saastech.amcmanager;

public class Customer {
	
	private int Cust_Id;
	private String Cust_Name;
	private String Cust_Mobileno1;
	private String Cust_Mobileno2;
	private String Cust_Phone;
	private String Cust_Address;
	private String Cust_Email;
	
	public Customer(){
		
	}
	public Customer(int Cust_Id,String Cust_Name,String Cust_Mobileno1,String Cust_Mobileno2,String Cust_Phone,String Cust_Address,String Cust_Email)
	{
		super();
		this.Cust_Id=Cust_Id;
		this.Cust_Name=Cust_Name;
		this.Cust_Mobileno1=Cust_Mobileno1;
		this.Cust_Mobileno2=Cust_Mobileno2;
		this.Cust_Phone=Cust_Phone;
		this.Cust_Address=Cust_Address;
		this.Cust_Email=Cust_Email;
	}
	public Customer(String Cust_Name,String Cust_Mobileno1,String Cust_Mobileno2,String cust_Phone,String Cust_Address,String Cust_Email)
	{
		super();
		this.Cust_Name=Cust_Name;
		this.Cust_Mobileno1=Cust_Mobileno1;
	     this.Cust_Mobileno2=Cust_Mobileno2;
	     this.Cust_Phone=cust_Phone;
		this.Cust_Address=Cust_Address;
		this.Cust_Email=Cust_Email;
	}
	public int getCustId()
	{
		return Cust_Id;
	}
	public void setCustId(int Cust_Id){
		this.Cust_Id=Cust_Id;
	}
	public String getCustName()
	{
		return Cust_Name;
	}
	public void setCustName(String Cust_Name){
		this.Cust_Name=Cust_Name;
	}
	public String getCustMobileno1()
	{
		return Cust_Mobileno1;
	}
	public void setCustMobileno1(String Cust_Mobileno1){
		this.Cust_Mobileno1=Cust_Mobileno1;
	}
	public String getCustMobileno2()
	{
		return Cust_Mobileno1;
	}
	public void setCustMobileno2(String Cust_Mobileno2){
		this.Cust_Mobileno2=Cust_Mobileno2;
	}
	public String getCustPhone()
	{
		return Cust_Phone;
	}
	public void setCusPhone(String Cust_Phone){
		this.Cust_Phone=Cust_Phone;
	}
	public String getCustAddress()
	{
		return Cust_Address;
	}
	public void setCustAddress(String Cust_Address){
		this.Cust_Address=Cust_Address;
	}
	public String getCustEmail()
	{
		return Cust_Email;
	}
	public void setCustEmail(String Cust_Email){
		this.Cust_Email=Cust_Email;
	}
   
}
