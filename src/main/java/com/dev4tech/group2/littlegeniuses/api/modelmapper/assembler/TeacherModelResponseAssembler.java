package com.dev4tech.group2.littlegeniuses.api.modelmapper.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.dev4tech.group2.littlegeniuses.api.model.response.TeacherModelResponse;
import com.dev4tech.group2.littlegeniuses.domain.entity.Teacher;

@Component
public class TeacherModelResponseAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public TeacherModelResponse toModel(Teacher teacher) {
		return modelMapper.map(teacher, TeacherModelResponse.class);
	}
	
	public Page<TeacherModelResponse> toCollectionModel(Page<Teacher> teachers) {
		return teachers.map(this::toModel);
	}
}
