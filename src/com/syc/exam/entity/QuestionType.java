package com.syc.exam.entity;

public class QuestionType {
	private int tid; //题目类型编号
	private String tname; //题目类型名称
	
	public QuestionType() {
		super();
	}
	
	public QuestionType(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	
}
