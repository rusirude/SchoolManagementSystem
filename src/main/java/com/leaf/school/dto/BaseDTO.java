package com.leaf.school.dto;
/**
 *@Author : Rusiru De Silva
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leaf.school.Utility.CommonConstant;

import java.io.Serializable;
import java.util.Date;

public class BaseDTO implements Serializable{
	

	private String addedBy;
	@JsonFormat(pattern = CommonConstant.DATE_FORMATE)
	private Date addedOn;		
	private String updatedBy;
	@JsonFormat(pattern = CommonConstant.DATE_FORMATE)
	private Date updatedOn;
	
	
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	public Date getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}
