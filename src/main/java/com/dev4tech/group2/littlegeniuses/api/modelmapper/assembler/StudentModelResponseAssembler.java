package com.dev4tech.group2.littlegeniuses.api.modelmapper.assembler;

import com.dev4tech.group2.littlegeniuses.api.model.response.StudentModelResponse;
import com.dev4tech.group2.littlegeniuses.domain.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class StudentModelResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public StudentModelResponse toModel(Student student) {
        return modelMapper.map(student, StudentModelResponse.class);
    }

    public Page<StudentModelResponse> toCollectionModel(Page<Student> students) {
        return students.map(this::toModel);
    }

}
