package com.cellphone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cellphone.base.impl.BaseServiceImpl;
import com.cellphone.dto.TypeDTO;
import com.cellphone.entities.Type;
import com.cellphone.repository.TypeRepository;
import com.cellphone.service.TypeService;

@Service
public class TypeServiceImpl extends BaseServiceImpl<Type> implements TypeService {

	@Autowired
	TypeRepository typeRepository;

	public TypeServiceImpl(TypeRepository typeRepository) {
		super(typeRepository, Type.class, TypeDTO.class);
	}
}
