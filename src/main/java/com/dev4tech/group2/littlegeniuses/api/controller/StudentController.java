package com.dev4tech.group2.littlegeniuses.api.controller;

import com.dev4tech.group2.littlegeniuses.api.model.request.StudentModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.response.StudentModelResponse;
import com.dev4tech.group2.littlegeniuses.api.modelmapper.assembler.StudentModelResponseAssembler;
import com.dev4tech.group2.littlegeniuses.api.modelmapper.disassembler.StudentModelRequestDisassembler;
import com.dev4tech.group2.littlegeniuses.domain.entity.Student;
import com.dev4tech.group2.littlegeniuses.domain.repository.StudentRepository;
import com.dev4tech.group2.littlegeniuses.domain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentModelResponseAssembler studentModelResponseAssembler;

    @Autowired
    private StudentModelRequestDisassembler studentModelRequestDisassembler;

    @GetMapping
    public Page<StudentModelResponse> findAll(@PageableDefault(value = 10) Pageable pageable) {
        Page<Student> students = studentRepository.findAll(pageable);

        Page<StudentModelResponse> studentModelResponse = studentModelResponseAssembler.toCollectionModel(students);

        return studentModelResponse;
    }

    @GetMapping(path = "/{id}")
    public StudentModelResponse findById(@PathVariable Long id) {
        Student student = studentService.findById(id);

        return studentModelResponseAssembler.toModel(student);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentModelResponse insert(@RequestBody @Valid StudentModelRequest studentModelRequest) {
        Student student = studentModelRequestDisassembler.toDomainObject(studentModelRequest);

        student = studentService.save(student);

        StudentModelResponse studentModelResponse = studentModelResponseAssembler.toModel(student);

        return studentModelResponse;
    }

    @PutMapping(value = "/{id}")
    public StudentModelResponse update(@PathVariable Long id, @RequestBody @Valid StudentModelRequest studentModelRequest) {
        Student currentStudent = studentService.findById(id);

        studentModelRequestDisassembler.copyToDomainObject(studentModelRequest, currentStudent);

        currentStudent = studentService.save(currentStudent);

        StudentModelResponse studentModelResponse = studentModelResponseAssembler.toModel(currentStudent);

        return studentModelResponse;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

}
