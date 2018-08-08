package com.mindtree.entity;

public class Patient {
	private int p_id;
	private String name;
	private String email;
	private int phone;
	private int DOB;
	
   Patient(int p_id,String name,String email,int phone,int DOB)
   {
	   this.p_id=p_id;
	   this.name=name;
	   this.email=email;
	   this.phone=phone;
	   this.DOB=DOB;
   }
   
   public Patient()
   {
	   super();
   }
   
   public int getp_id( ) {
	      return p_id;
	   }
	   
	   public void setp_id(int eid) {
	      this.p_id = p_id;
	   }
	   
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name=name;
	}
	
	public String getemail() {
		return email;
	}
	
	public void setemail(String email) {
		this.email=email;
	}
	
	public int getphone( ) {
	      return phone;
	   }
	   
	   public void setphone(int phone) {
	      this.phone=phone;
	   }
	
	   public int getDOB( ) {
		      return DOB;
		   }
		   
		   public void setDOB(int  DOB) {
		      this.DOB=DOB;
		   }
		   
		   public String toString() {
			      return "Patient [p_id=" + p_id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", DOB=" + DOB +"]";
			   }
}