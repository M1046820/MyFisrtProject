package com.mindtree.dao;


import com.mindtree.entity.Test;
import com.mindtree.establish.Conn;
import com.mindtree.service.MyException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class DatabaseConn implements DaoInt {

	
	Connection con;
	public DatabaseConn() throws MyException
	{
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/diagnostic_dB","root","Welcome123");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		catch(SQLException ex)
//		{
//			//ex.printStackTrace();
//			throw new MyException("Error with connectivity");
//		}
		
		Conn objj =new Conn();
		con=objj.getConnection();
	}
	
	public void testDetailsByEmail(String email,String testName)throws  MyException
	{
		//PID as per email
		try
		{
		PreparedStatement getPatientQuery = con.prepareStatement("Select p_id from  patient where email=?");
		getPatientQuery.setString(1, email);
		
		ResultSet emailResultSet = getPatientQuery.executeQuery();
		int pid=-1;
		if(emailResultSet.next())
		{
			pid = emailResultSet.getInt(1);
		}
		emailResultSet.close();
		//Get TID
		PreparedStatement getTIDQuery = con.prepareStatement("Select t_id from test where name=?");
		getTIDQuery.setString(1, testName);
		int tid=-1;
		ResultSet tidResultSet = getTIDQuery.executeQuery();
		if(tidResultSet.next())
		{
			tid = tidResultSet.getInt(1);
		}
		if(pid>0 && tid>0)
		{
			
			//setting current date
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formatter.format(date);
			//prepared statement call
			PreparedStatement insertPatientDetails=con.prepareStatement("insert into patient_test values(?,?,?)");
			insertPatientDetails.setInt(1, pid);
			insertPatientDetails.setInt(2, tid);
			insertPatientDetails.setString(3, strDate);
			insertPatientDetails.executeUpdate();
		}
		} catch (SQLException e) {
			throw new MyException("invalid");
			//e.printStackTrace();
		}
		//else
		//{
			//System.out.println("Invalid data");
		//}
		
	}
	
	public void testDetailsByPhone(String phone,String testName)throws SQLException
	{
		//PID as per email
		
		
		PreparedStatement getPatientQuery = con.prepareStatement("Select p_id from patient where phone=?");
		getPatientQuery.setString(1, phone);
		
		ResultSet phoneResultSet = getPatientQuery.executeQuery();
		int pid=-1;
		if(phoneResultSet.next())
		{
			pid = phoneResultSet.getInt(1);
		}
		phoneResultSet.close();
		//System.out.println(pid);
		//Get TID
		PreparedStatement getTIDQuery = con.prepareStatement("Select t_id from test where name=?");
		getTIDQuery.setString(1, testName);
		int tid=-1;
		ResultSet tidResultSet = getTIDQuery.executeQuery();
		if(tidResultSet.next())
		{
			tid = tidResultSet.getInt(1);
		}
		try
		{
		if(pid>0 && tid>0)
		{
			
			//setting current date
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formatter.format(date);
			//prepared statement call
			PreparedStatement insertPatientDetails=con.prepareStatement("insert into patient_test values(?,?,?)");
			insertPatientDetails.setInt(1, pid);
			insertPatientDetails.setInt(2, tid);
			insertPatientDetails.setString(3, strDate);
			insertPatientDetails.executeUpdate();
		}
		}catch(SQLException e)
		{
			System.out.println("invalid data");
		}
		//else
		//{
			//System.out.println("Invalid data");
		//}
	}

	public ArrayList<DaoMethod> report(String receive, String testDate,String status) throws SQLException, MyException {
		// TODO Auto-generated method stub
	
		//Test t=new Test();
		
		PreparedStatement getRep=null;
		if(status.equals("e")){
			getRep = con.prepareStatement("select p.name , p.email, p.phone , pt.date , t.name ,t.cost from patient p inner join patient_test pt inner join test t on p.p_id=pt.p_id and t.t_id=pt.t_id and p.email=? and pt.date=? order by t.name");
			
		}
		else if(status.equals("p"))
		{
			getRep = con.prepareStatement("select p.name , p.email, p.phone , pt.date , t.name,t.cost from patient p inner join patient_test pt inner join test t on p.p_id=pt.p_id and t.t_id=pt.t_id and p.phone=? and pt.date=? order by t.name");
		}
		getRep.setString(1,receive);
		getRep.setString(2, testDate.trim());
		ResultSet rSet=getRep.executeQuery();
		ArrayList<DaoMethod> reportList=new ArrayList<DaoMethod>();
		while(rSet.next()){
			DaoMethod obj = new DaoMethod();
			obj.setPatientName(rSet.getString(1));
			obj.setPatientEmail(rSet.getString(2));
			obj.setPatientPhone(rSet.getString(3));
			obj.setDate(rSet.getString(4));
			obj.setTestName(rSet.getString(5));
			obj.setTestCost(rSet.getString(6));
			reportList.add(obj);
		//System.out.println(rSet.getString(1)+" "+rSet.getString(2)+" "+rSet.getString(3)+" "+rSet.getString(4)+" "+rSet.getString(5));
		}
		Conn connect= new Conn();
		connect.closeConnection();
		return reportList;
	}
		
		
}
