package com.cellphone.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dataSearch = "";
	
	private int pageIndex = 1;

	private int pageSize = 10;

	private String sortBy = "";

	private boolean descending = true;

}
