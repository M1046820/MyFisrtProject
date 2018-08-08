package com.mindtree.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.service.MyException;

public interface DaoInt {
	
	public void testDetailsByEmail(String email,String testName) throws MyException;
	public void testDetailsByPhone(String phone,String testName) throws SQLException;
	public  ArrayList<DaoMethod> report(String receive, String testDate,String status) throws MyException, SQLException;

}
