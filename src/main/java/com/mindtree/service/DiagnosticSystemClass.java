package com.mindtree.service;

import java.sql.SQLException;

public class DiagnosticSystemClass implements ServiceInt {

	public void testDetails() throws MyException, SQLException {
		// TODO Auto-generated method stub
		Function fn=new Function();
		try{
		
			fn.testDetails();
			
		}
		catch(MyException e){
			//System.out.println("Invalid data");
			e.message();
		}
		
		
	}

	public void generateReport() throws IndexOutOfBoundsException, MyException {
		// TODO Auto-generated method stub
		try
		{
		Function fn=new Function();
		fn.generateReport();
	}
		catch(IndexOutOfBoundsException e) {
			System.out.println("index out of bound" );
		}
	}

	
	
}
