package com.dev4tech.group2.littlegeniuses.api.modelmapper.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.dev4tech.group2.littlegeniuses.api.model.response.ClassModelResponse;
import com.dev4tech.group2.littlegeniuses.domain.entity.Class;

@Component
public class ClassModelResponseAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public ClassModelResponse toModel(Class classroom) {
		return modelMapper.map(classroom, ClassModelResponse.class);
	}
	
	public Page<ClassModelResponse> toCollectionModel(Page<Class> classes) {
		return classes.map(this::toModel);
	}
}
