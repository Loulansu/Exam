package com.syc.exam.entity;

public class Classes {
	private int cid; //班级编号
	private String name; //班级名称
	
	public Classes() {
		super();
	}
	public Classes(int cid, String name) {
		super();
		this.cid = cid;
		this.name = name;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
