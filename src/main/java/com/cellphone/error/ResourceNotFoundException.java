package com.cellphone.error;

import java.util.List;

import com.cellphone.common.CustomeObject;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private List<CustomeObject> objects;

	private final Class<?> clazz;

	private final Long id;

	public ResourceNotFoundException(String message) {
		super(message);
		this.objects = null;
		this.clazz = null;
		this.id = null;
	}

	public ResourceNotFoundException(Class<?> clazz, Long id) {
		this.clazz = clazz;
		this.id = id;
	}

	public ResourceNotFoundException(String message, List<CustomeObject> objects) {
		super(message);
		this.objects = objects;
		this.clazz = null;
		this.id = null;
	}

	public List<CustomeObject> getObjects() {
		return objects;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public Long getId() {
		return id;
	}

}