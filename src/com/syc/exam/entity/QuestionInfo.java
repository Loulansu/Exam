package com.syc.exam.entity;

public class QuestionInfo {
	private int qid; //题目编号
	private int tid; //类型编号
	private String content; //题目内容
	private String answer; //题目答案
	private int answerCount; //答题次数
	private int corretCount; //正确次数
	private int lid; //难度编号
	private String option1; //选项1
	private String option2; //选项2
	private String option3; //选项3
	private String option4; //选项4
	private String expression; //解释
	private int coid; //课程编号
	
	public QuestionInfo(int qid, int tid, String content, String answer, int answerCount, int corretCount, int lid,
			String option1, String option2, String option3, String option4, String expression, int coid) {
		super();
		this.qid = qid;
		this.tid = tid;
		this.content = content;
		this.answer = answer;
		this.answerCount = answerCount;
		this.corretCount = corretCount;
		this.lid = lid;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.expression = expression;
		this.coid = coid;
	}
	
	public QuestionInfo() {
		super();
	}
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	public int getCorretCount() {
		return corretCount;
	}
	public void setCorretCount(int corretCount) {
		this.corretCount = corretCount;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public int getCoid() {
		return coid;
	}
	public void setCoid(int coid) {
		this.coid = coid;
	}
	
	
}
