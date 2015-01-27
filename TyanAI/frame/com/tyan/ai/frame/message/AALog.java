package com.tyan.ai.frame.message;

import java.util.Date;

import com.tyan.ai.tool.HibernateTool;

public class AALog {
	private int id;
	private Date date;
	private String question;
	private String anster;
	private String Satisfied;
	public AALog() {
		// TODO Auto-generated constructor stub
	}
	public AALog(Date date, AskMessage ask, AnsterMessage anster){
		super();
		this.date = date;
		this.question = ask.getMessage();
		this.anster = anster.getMessage();
		Satisfied = null;
	}
	public AALog(Date date, String question, String anster) {
		super();
		this.date = date;
		this.question = question;
		this.anster = anster;
		Satisfied = null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnster() {
		return anster;
	}
	public void setAnster(String anster) {
		this.anster = anster;
	}
	public String getSatisfied() {
		return Satisfied;
	}
	public void setSatisfied(String satisfied) {
		Satisfied = satisfied;
	}
}
