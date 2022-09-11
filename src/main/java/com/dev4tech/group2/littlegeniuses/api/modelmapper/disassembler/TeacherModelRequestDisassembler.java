package com.dev4tech.group2.littlegeniuses.api.modelmapper.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev4tech.group2.littlegeniuses.api.model.request.TeacherModelRequest;
import com.dev4tech.group2.littlegeniuses.domain.entity.Teacher;

@Component
public class TeacherModelRequestDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Teacher toDomainObject(TeacherModelRequest teacherModelRequest) {
		return modelMapper.map(teacherModelRequest, Teacher.class);
	}
	
	public void copyToDomainObject(TeacherModelRequest teacherModelRequest, Teacher teacher) {
		modelMapper.map(teacherModelRequest, teacher);
	}
}
