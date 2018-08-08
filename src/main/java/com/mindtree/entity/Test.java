package com.mindtree.entity;

public class Test {
	private int t_id;
	private String testName;
	private int cost;
	
	Test(int t_id,String testNmae,int cost)
	{
		this.t_id=t_id;
		this.testName=testName;
		this.cost=cost;
	}
	
	public int gett_id() {
	return t_id;
	}
	
	public void sett_id(int t_id) {
		this.t_id=t_id;
	}
	
	public String gettestName() {
		return testName;
	}
	
	public void settestName(String testName) {
		this.testName=testName;
	}
	
	public int getcost() {
		return cost;
	}
	public void setcost(int cost) {
		this.cost=cost;
	}
	
	public String toString() {
		 return "Test [t_id=" + t_id + ", testName=" + testName + ", cost=" + cost + "]";
	}

}