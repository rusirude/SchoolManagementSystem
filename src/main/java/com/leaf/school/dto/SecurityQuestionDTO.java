package com.leaf.school.dto;

public class SecurityQuestionDTO extends BaseDTO{
	

	private static final long serialVersionUID = -374634523171291220L;
	
	private Integer id;
	private String question;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	

}
