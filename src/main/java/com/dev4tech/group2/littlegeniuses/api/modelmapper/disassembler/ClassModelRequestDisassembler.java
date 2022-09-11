package com.dev4tech.group2.littlegeniuses.api.modelmapper.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev4tech.group2.littlegeniuses.api.model.request.ClassModelRequest;
import com.dev4tech.group2.littlegeniuses.domain.entity.Class;

@Component
public class ClassModelRequestDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Class toDomainObject(ClassModelRequest classModelRequest) {
		return modelMapper.map(classModelRequest, Class.class);
	}
	
	public void copyToDomainObject(ClassModelRequest classModelRequest, Class c) {
		modelMapper.map(classModelRequest, c);
	}
}
