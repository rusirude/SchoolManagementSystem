package com.leaf.school.dto;

public class SecurityQuestionDTO extends BaseDTO{
	

	private static final long serialVersionUID = -374634523171291220L;
	
	private Long id;
	private String question;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	

}
