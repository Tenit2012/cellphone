package com.cellphone.error;

import java.io.Serializable;

import javax.lang.model.type.ErrorType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private ErrorType title;
	private String detail;
	private String time;
}
