/**
 * @Author : Rusiru De Silva
 */
package com.leaf.school.dto.common;

import java.io.Serializable;

public class AjaxResponseDTO implements Serializable{

	private static final long serialVersionUID = -10550238447776990L;
	
	private String code;
	private String errorMsg;
	private Object obj;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}

	public AjaxResponseDTO(String code, String errorMsg) {
		this.code = code;
		this.errorMsg = errorMsg;
	}
}
