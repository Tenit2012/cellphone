package com.cellphone.error;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldErrors implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String field;
	private String value;
	private String reason;

	public FieldErrors(String field, String value, String reason) {
		this.field = field;
		this.value = value;
		this.reason = reason;
	}

}
