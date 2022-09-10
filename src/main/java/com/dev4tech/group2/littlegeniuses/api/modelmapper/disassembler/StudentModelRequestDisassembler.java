package com.dev4tech.group2.littlegeniuses.api.modelmapper.disassembler;

import com.dev4tech.group2.littlegeniuses.api.model.request.StudentModelRequest;
import com.dev4tech.group2.littlegeniuses.domain.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentModelRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Student toDomainObject(StudentModelRequest studentModelRequest) {
        return modelMapper.map(studentModelRequest, Student.class);
    }

    public void copyToDomainObject(StudentModelRequest studentModelRequest, Student student) {
        modelMapper.map(studentModelRequest, student);
    }

}
