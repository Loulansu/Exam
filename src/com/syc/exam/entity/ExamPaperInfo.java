package com.syc.exam.entity;

public class ExamPaperInfo {
	private int eid; //试卷编号
	private String questions; //题目编号-题目答案
	private String ename; //试卷名称
	private int choice; //单选题个数
	private int doubleChoice; //多选题个数
	private int judge; //判断题个数
	private String startTime; //开始时间
	private int persistTime; //考试时长（分钟）
	private int lid; //难度编号
	private int flag; //试卷状态（已阅卷，未阅卷）
	
	public ExamPaperInfo(int eid, String questions, String ename, int choice, int doubleChoice, int judge,
			String startTime, int persistTime, int lid, int flag) {
		super();
		this.eid = eid;
		this.questions = questions;
		this.ename = ename;
		this.choice = choice;
		this.doubleChoice = doubleChoice;
		this.judge = judge;
		this.startTime = startTime;
		this.persistTime = persistTime;
		this.lid = lid;
		this.flag = flag;
	}
	
	public ExamPaperInfo() {
		super();
	}

	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
	public int getDoubleChoice() {
		return doubleChoice;
	}
	public void setDoubleChoice(int doubleChoice) {
		this.doubleChoice = doubleChoice;
	}
	public int getJudge() {
		return judge;
	}
	public void setJudge(int judge) {
		this.judge = judge;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public int getPersistTime() {
		return persistTime;
	}
	public void setPersistTime(int persistTime) {
		this.persistTime = persistTime;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
}
