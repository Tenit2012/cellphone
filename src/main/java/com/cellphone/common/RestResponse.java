package com.cellphone.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;

@Getter
public class RestResponse<T> {

	private RestResponseStatus status;
	
	@JsonInclude(Include.NON_NULL)
	private T data;
	
	public RestResponse(RestResponseStatus status, T data){
		this.status = status;
		this.data = data;
	}

}
