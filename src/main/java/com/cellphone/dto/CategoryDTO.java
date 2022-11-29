package com.cellphone.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = -5899270950529445699L;

	private Long categoryId;
	private String name;
	private String description;
	private String image;
	private boolean disable;
}
