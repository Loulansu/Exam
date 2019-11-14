package com.syc.exam.entity;

public class Course {
	private int coid; //课程编号
	private String cname; //课程名称
	
	public Course(int coid, String cname) {
		super();
		this.coid = coid;
		this.cname = cname;
	}
	public Course() {
		super();
	}
	public int getCoid() {
		return coid;
	}
	public void setCoid(int coid) {
		this.coid = coid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
