package com.dev4tech.group2.littlegeniuses.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev4tech.group2.littlegeniuses.api.model.request.StudentModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.response.StudentModelResponse;
import com.dev4tech.group2.littlegeniuses.api.modelmapper.assembler.StudentModelResponseAssembler;
import com.dev4tech.group2.littlegeniuses.api.modelmapper.disassembler.StudentModelRequestDisassembler;
import com.dev4tech.group2.littlegeniuses.api.openapi.controller.StudentControllerOpenApi;
import com.dev4tech.group2.littlegeniuses.domain.entity.Student;
import com.dev4tech.group2.littlegeniuses.domain.repository.StudentRepository;
import com.dev4tech.group2.littlegeniuses.domain.service.StudentService;

@RestController
@RequestMapping(path = "/students")
public class StudentController implements StudentControllerOpenApi {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentModelResponseAssembler studentModelResponseAssembler;

    @Autowired
    private StudentModelRequestDisassembler studentModelRequestDisassembler;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<StudentModelResponse> findAll(@PageableDefault(value = 10) Pageable pageable) {
        Page<Student> students = studentRepository.findAll(pageable);

        Page<StudentModelResponse> studentModelResponse = studentModelResponseAssembler.toCollectionModel(students);

        return studentModelResponse;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentModelResponse findById(@PathVariable Long id) {
        Student student = studentService.findById(id);

        return studentModelResponseAssembler.toModel(student);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public StudentModelResponse insert(@RequestBody @Valid StudentModelRequest studentModelRequest) {
        Student student = studentModelRequestDisassembler.toDomainObject(studentModelRequest);

        student = studentService.save(student);

        StudentModelResponse studentModelResponse = studentModelResponseAssembler.toModel(student);

        return studentModelResponse;
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentModelResponse update(@PathVariable Long id, @RequestBody @Valid StudentModelRequest studentModelRequest) {
        Student currentStudent = studentService.findById(id);

        studentModelRequestDisassembler.copyToDomainObject(studentModelRequest, currentStudent);

        currentStudent = studentService.save(currentStudent);

        StudentModelResponse studentModelResponse = studentModelResponseAssembler.toModel(currentStudent);

        return studentModelResponse;
    }

    @DeleteMapping(value = "/{id}", produces = {})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

}
