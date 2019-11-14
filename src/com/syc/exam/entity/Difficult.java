package com.syc.exam.entity;

public class Difficult {
	private int lid; //难度编号
	private int level; //难度系数
	
	public Difficult() {
		super();
	}
	public Difficult(int lid, int level) {
		super();
		this.lid = lid;
		this.level = level;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
