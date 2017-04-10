package com.leaf.school.dto.common;
/**
 * @Author : Rusiru De Silva
 */

import java.io.Serializable;

public class AjaxResponseDTO implements Serializable {

    private static final long serialVersionUID = -10550238447776990L;

    private String code;
    private String message;
    private Object obj;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public AjaxResponseDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
