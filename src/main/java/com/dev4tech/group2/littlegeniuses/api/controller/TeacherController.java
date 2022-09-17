package com.dev4tech.group2.littlegeniuses.api.controller;

import com.dev4tech.group2.littlegeniuses.api.model.request.TeacherModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.response.TeacherModelResponse;
import com.dev4tech.group2.littlegeniuses.api.modelmapper.assembler.TeacherModelResponseAssembler;
import com.dev4tech.group2.littlegeniuses.api.modelmapper.disassembler.TeacherModelRequestDisassembler;
import com.dev4tech.group2.littlegeniuses.config.security.CheckSecurity;
import com.dev4tech.group2.littlegeniuses.domain.entity.Teacher;
import com.dev4tech.group2.littlegeniuses.domain.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherModelResponseAssembler teacherModelResponseAssembler;

    @Autowired
    private TeacherModelRequestDisassembler teacherModelRequestDisassembler;

    @CheckSecurity.Teachers.CanConsult
    @GetMapping
    public Page<TeacherModelResponse> findAll(@PageableDefault(value = 10) Pageable pageable) {
        Page<Teacher> teachers = teacherService.findAll(pageable);
        Page<TeacherModelResponse> teacherModel = teacherModelResponseAssembler.toCollectionModel(teachers);
        return teacherModel;
    }

    @CheckSecurity.Teachers.CanConsult
    @GetMapping(path = "/{id}")
    public TeacherModelResponse findById(@PathVariable Long id) {
        Teacher teacher = teacherService.findById(id);
        return teacherModelResponseAssembler.toModel(teacher);
    }

    @CheckSecurity.Teachers.CanEdit
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherModelResponse insert(@RequestBody @Valid TeacherModelRequest teacherModelRequest) {
        Teacher teacher = teacherModelRequestDisassembler.toDomainObject(teacherModelRequest);
        teacher = teacherService.save(teacher);
        TeacherModelResponse teacherModelResponse = teacherModelResponseAssembler.toModel(teacher);
        return teacherModelResponse;
    }

    @CheckSecurity.Teachers.CanEdit
    @PutMapping(value = "/{id}")
    public TeacherModelResponse update(@PathVariable Long id, @RequestBody @Valid TeacherModelRequest teacherModelRequest) {
        Teacher teacher = teacherService.findById(id);
        teacherModelRequestDisassembler.copyToDomainObject(teacherModelRequest, teacher);
        teacher = teacherService.save(teacher);
        TeacherModelResponse teacherModelResponse = teacherModelResponseAssembler.toModel(teacher);
        return teacherModelResponse;
    }

    @CheckSecurity.Teachers.CanEdit
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        teacherService.delete(id);
    }
}
