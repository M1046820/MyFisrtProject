package com.mindtree.service;

import com.mindtree.client.MainClass; 

import com.mindtree.dao.DatabaseConn;

import java.sql.SQLException;
import java.util.*;
import java.util.regex.*;

import com.mindtree.dao.DaoMethod;
import com.mysql.jdbc.PreparedStatement;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;
public class Function{

	Scanner sc=new Scanner(System.in);
	public void testDetails()throws MyException, SQLException {
		// TODO Auto-generated method stub
		
		Function func=new Function();

		System.out.println("======Enter test details:======");
		System.out.println("1.Fetch patient details by email:");
		System.out.println("2.Fetch patient details by phone:");
		System.out.println("3.EXIT");
		System.out.println("Enter your choice:");
		int choice=Integer.parseInt(sc.nextLine());
		
		boolean flag = true;
		//do{
			switch(choice){
			case 1:
				System.out.println("Enter Email");
				String email=sc.nextLine();
				Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		        java.util.regex.Matcher mat = pattern.matcher(email);

		        if(mat.matches()){   
		        }
		        else
		        {
		        	throw new MyException("invalid email");
		        }
				func.addtest(email,"e");
				break;
				
			case 2:
				System.out.println("Enter phone no:");
				String phone=sc.nextLine();
				func.addtest(phone,"p");
				break;
			case 3:
				System.out.println("returning");
				
				break;
				
				
			}
			
			
//			System.out.println("======Enter test details:======");
//			System.out.println("1.Fetch patient details by email:");
//			System.out.println("2.Fetch patient details by phone:");
//			System.out.println("3.EXIT");
//			System.out.println("Enter your choice:");
//			=
		//}while(flag);
	}

	private void addtest(String receive,String status) throws MyException, SQLException {
		//MainCaller mc=new MainCaller();
		// TODO Auto-generated method stub
		System.out.println("Enter the test name:");
		String testName=sc.nextLine();
		
		DatabaseConn addPatientTestConn =new DatabaseConn();
		try {
		if(status.equals("e"))
		{
			
			addPatientTestConn.testDetailsByEmail(receive, testName);
						
			System.out.println("Want to add more tests [YES/NO]");
			String yesNO=sc.nextLine();
			if(yesNO.equals("YES")){
				addtest(receive,"e");
			}
			if(yesNO.equals("NO")){
				System.out.println("Test details are successfully saved");
				testDetails();
				//System.exit(0);
			}
		}
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		catch (MyException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		if(status.equals("p"))
		{
			
			
			try {
				addPatientTestConn.testDetailsByPhone(receive, testName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid data");
				e.printStackTrace();
			};
			
			System.out.println("Want to add more tests [YES/NO]");
			String yesNO=sc.nextLine();
			if(yesNO.equals("YES")){
				addtest(receive,"p");
			}
			if(yesNO.equals("NO")){
				System.out.println("Test details are successfully saved");
				testDetails();
				//System.exit(0);
			}
			
		}
	}

	public void generateReport() throws MyException {
		// TODO Auto-generated method stub
		Function func=new Function();
		System.out.println("=====GENERATE REPORT=====");
		System.out.println("1.Fetch patient details by email:");
		System.out.println("2.Fetch patient details by phone:");
		System.out.println("Enter your choice:");
		int choice=Integer.parseInt(sc.nextLine());
		DatabaseConn viewDetails = new DatabaseConn();
		//do{
			switch(choice){
			case 1:
				System.out.println("Enter Email");
				String email=sc.nextLine();
				System.out.println("Enter testDate:");
				String testDate=sc.nextLine();
				
				
				try {
					ArrayList<DaoMethod> list=viewDetails.report(email,testDate,"e");
					
					
					display(list);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 2:
				System.out.println("Enter phone no:");
				String phone=sc.nextLine();
				System.out.println("Enter testDate:");
				testDate=sc.nextLine();

				try {
					ArrayList<DaoMethod> list=viewDetails.report(phone,testDate,"p");
					display(list);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid data");
					e.printStackTrace();
				}
				break;
				
			case 3:
				return;
			}
			
			
			
			
		//}while(choice!=3);
		
	}

	

	public void display(ArrayList<DaoMethod> list){
		int sum=0;
		System.out.println("=========OUTPUT==========");
		System.out.println("Name="+list.get(0).getPatientName());
		System.out.println("Email="+list.get(0).getPatientEmail());
		System.out.println("Phone="+list.get(0).getPatientPhone());
		System.out.println("Date="+list.get(0).getDate());
		
		System.out.println("Test Details");
		for(DaoMethod obj:list){
			System.out.println(obj.getTestName()+" "+obj.getTestCost());
			sum = sum+ Integer.valueOf(obj.getTestCost());
		}
		
		System.out.println("Total cost");
		System.out.println(sum);
		
	}
	

}
