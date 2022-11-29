package com.cellphone.error;

import java.io.Serializable;
import java.util.List;

import com.cellphone.common.CustomeObject;
import com.cellphone.common.RestResponseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private RestResponseStatus status;
	private ErrorDetail error;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<FieldErrors> fieldErrors;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<CustomeObject> moreInfos;

	public ErrorResponse(RestResponseStatus status, ErrorDetail error) {
		this.status = status;
		this.error = error;
	}

	public ErrorResponse(RestResponseStatus status, ErrorDetail error, List<FieldErrors> fieldErrors) {
		this.status = status;
		this.error = error;
		this.fieldErrors = fieldErrors;
	}

	public ErrorResponse(RestResponseStatus status, ErrorDetail error, List<FieldErrors> fieldErrors,
			List<CustomeObject> moreInfos) {
		this.status = status;
		this.error = error;
		this.fieldErrors = fieldErrors;
		this.moreInfos = moreInfos;
	}

}
