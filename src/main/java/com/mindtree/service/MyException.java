package com.mindtree.service;

public class MyException extends Exception {
	
	  public MyException(String str)
	  {
		  //System.out.println(str);
		  super(str);
	  }
	  public void message()
	  {
		  System.out.println("Invalid data");
	  }
}
