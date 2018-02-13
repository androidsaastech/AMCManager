package com.saastech.amcmanager;

public class Service {
	private int Service_Id;
	private int Serv_Cust_Id;
	private String Serv_Req;
	private String Serv_Type;
	private String Serv_StartDate;
	private String Serv_Renewal_1;
	private String Serv_Renewal_2;
	private String Serv_Renewal_3;
	private String Serv_Renewal_4;
	private String Serv_Renewal_5;
	private String Serv_Renewal_6;
	private String Serv_Renewal_7;
	private String Serv_Renewal_8;
	private String Serv_Renewal_9;
	private String Serv_Renewal_10;
	private String Serv_Renewal_11;
	private String Serv_Renewal_12;
	private String Serv_Mobile1;
	private String Serv_Email;
	public Service(){}
	
	public Service(int Service_Id,int  Serv_Cust_Id,String Serv_Req,String Serv_Type,String Serv_StartDate,String Serv_Renewal1,String Serv_Renewal2,String Serv_Renewal3,
			String Serv_Renewal4,String Serv_Renewal5,String Serv_Renewal6,String Serv_Renewal7,String Serv_Renewal8,String Serv_Renewal9,String Serv_Renewal10,
			String Serv_Renewal11,String Serv_Renewal12,String Serv_Mobile1,String Serv_Email){
		super();
		this.Service_Id=Service_Id;
		this.Serv_Cust_Id=Serv_Cust_Id;
		this.Serv_Req=Serv_Req;
		this.Serv_Type=Serv_Type;
		this.Serv_StartDate=Serv_StartDate;
		this.Serv_Renewal_1=Serv_Renewal1;
		this.Serv_Renewal_2=Serv_Renewal2;
		this.Serv_Renewal_3=Serv_Renewal3;
		this.Serv_Renewal_4=Serv_Renewal4;
		this.Serv_Renewal_5=Serv_Renewal5;
		this.Serv_Renewal_6=Serv_Renewal6;
		this.Serv_Renewal_7=Serv_Renewal7;
		this.Serv_Renewal_8=Serv_Renewal8;
		this.Serv_Renewal_9=Serv_Renewal9;
		this.Serv_Renewal_10=Serv_Renewal10;
		this.Serv_Renewal_11=Serv_Renewal11;
		this.Serv_Renewal_12=Serv_Renewal12;
		this.Serv_Mobile1=Serv_Mobile1;
		this.Serv_Email=Serv_Email;
	}
	public Service(int  Serv_Cust_Id,String Serv_Req,String Serv_Type,String Serv_StartDate,String Serv_Renewal1,String Serv_Renewal2,String Serv_Renewal3,
			String Serv_Renewal4,String Serv_Renewal5,String Serv_Renewal6,String Serv_Renewal7,String Serv_Renewal8,String Serv_Renewal9,
			String Serv_Renewal10,String Serv_Renewal11,String Serv_Renewal12,String Serv_Mobile1,String Serv_Email){
		super();
		this.Serv_Cust_Id=Serv_Cust_Id;
		this.Serv_Req=Serv_Req;
		this.Serv_Type=Serv_Type;
		this.Serv_StartDate=Serv_StartDate;
		this.Serv_Renewal_1=Serv_Renewal1;
		this.Serv_Renewal_2=Serv_Renewal2;
		this.Serv_Renewal_3=Serv_Renewal3;
		this.Serv_Renewal_4=Serv_Renewal4;
		this.Serv_Renewal_5=Serv_Renewal5;
		this.Serv_Renewal_6=Serv_Renewal6;
		this.Serv_Renewal_7=Serv_Renewal7;
		this.Serv_Renewal_8=Serv_Renewal8;
		this.Serv_Renewal_9=Serv_Renewal9;
		this.Serv_Renewal_10=Serv_Renewal10;
		this.Serv_Renewal_11=Serv_Renewal11;
		this.Serv_Renewal_12=Serv_Renewal12;
		this.Serv_Mobile1=Serv_Mobile1;
		this.Serv_Email=Serv_Email;
	}
	public int getServiceId()
	{
		return Service_Id;
	}
	public void setServiceId(int ServiceID){
		this.Service_Id=ServiceID;
	}
	public int getServCustId()
	{
		return Serv_Cust_Id;
	}
	public void setServCustId(int Serv_Cust_Id){
		this.Serv_Cust_Id=Serv_Cust_Id;
	}
	public String getServReq()
	{
		return Serv_Req;
	}
	public void setServReq(String Serv_Req){
		this.Serv_Req=Serv_Req;
	}
	public String getServCustType()
	{
		return Serv_Type;
	}
	public void setServType(String Serv_Type){
		this.Serv_Type=Serv_Type;
	}
	public String getServStartDate()
	{
		return Serv_StartDate;
	}
	public void setServStartDate(String Serv_StartDate){
		this.Serv_StartDate=Serv_StartDate;
	}
	public String getServRenewal1()
	{
		return Serv_Renewal_1;
	}
	public void setServRenewal1(String Serv_Renewal1){
		this.Serv_Renewal_1=Serv_Renewal1;
	}
	public String getServRenewal2()
	{
		return Serv_Renewal_2;
	}
	public void setServRenewal2(String Serv_Renewal2){
		this.Serv_Renewal_2=Serv_Renewal2;
	}
	public String getServRenewal3()
	{
		return Serv_Renewal_3;
	}
	public void setServRenewal3(String Serv_Renewal3){
		this.Serv_Renewal_3=Serv_Renewal3;
	}
	public String getServRenewal4()
	{
		return Serv_Renewal_4;
	}
	public void setServRenewal4(String Serv_Renewal4){
		this.Serv_Renewal_4=Serv_Renewal4;
	}
	public String getServRenewal5()
	{
		return Serv_Renewal_5;
	}
	public void setServRenewal5(String Serv_Renewal5){
		this.Serv_Renewal_5=Serv_Renewal5;
	}
	public String getServRenewal6()
	{
		return Serv_Renewal_6;
	}
	public void setServRenewal6(String Serv_Renewal6){
		this.Serv_Renewal_6=Serv_Renewal6;
	}
	public String getServRenewal7()
	{
		return Serv_Renewal_7;
	}
	public void setServRenewal7(String Serv_Renewal7){
		this.Serv_Renewal_7=Serv_Renewal7;
	}
	public String getServRenewal8()
	{
		return Serv_Renewal_8;
	}
	public void setServRenewal8(String Serv_Renewal8){
		this.Serv_Renewal_8=Serv_Renewal8;
	}
	public String getServRenewal9()
	{
		return Serv_Renewal_9;
	}
	public void setServRenewal9(String Serv_Renewal9){
		this.Serv_Renewal_9=Serv_Renewal9;
	}
	public String getServRenewal10()
	{
		return Serv_Renewal_10;
	}
	public void setServRenewal10(String Serv_Renewal10){
		this.Serv_Renewal_10=Serv_Renewal10;
	}
	public String getServRenewal11()
	{
		return Serv_Renewal_11;
	}
	public void setServRenewal11(String Serv_Renewal11){
		this.Serv_Renewal_11=Serv_Renewal11;
	}
	public String getServRenewal12()
	{
		return Serv_Renewal_12;
	}
	public void setServRenewal12(String Serv_Renewal12){
		this.Serv_Renewal_12=Serv_Renewal12;
	}
	public String getServMobile1()
	{
		return Serv_Mobile1;
	}
	public void setServMobile1(String Serv_Mobile1){
		this.Serv_Mobile1=Serv_Mobile1;
	}
	public String getServEmail()
	{
		return Serv_Email;
	}
	public void setServEmail(String Serv_Email){
		this.Serv_Email=Serv_Email;
	}


}
