package com.mindtree.client;

	//import DiagnosticSystemClass;
	import com.mindtree.service.DiagnosticSystemClass;
	import com.mindtree.service.Function;
	import com.mindtree.service.MyException;

import java.sql.SQLException;
import java.util.Scanner;

	public class MainClass {

	public static void main(String [] args) throws MyException, SQLException{
			DiagnosticSystemClass ds=new DiagnosticSystemClass();
			//FunctionClass fun=new FunctionClass();
			Scanner sc=new Scanner(System.in);
			System.out.println("=============DIAGNOSTIC CENTRE=============");
			System.out.println("1.Add diagnostic tests");
			System.out.println("2.Generate Report");
			System.out.println("3.EXIT");
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			do {
				switch(choice){
					case 1:
						ds.testDetails();
						break;
					case 2:
						ds.generateReport();
						break;
					case 3:
						System.exit(0);
						break;
				}
				System.out.println("=============DIAGNOSTIC CENTRE=============");
				System.out.println("1.Add diagnostic tests");
				System.out.println("2.Generate Report");
				System.out.println("3.EXIT");
				System.out.println("Enter your choice:");
				System.out.println("Enter:");
				choice=sc.nextInt();
				
			}while(choice != 4);
		}
	}

