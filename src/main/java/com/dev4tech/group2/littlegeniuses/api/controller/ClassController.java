package com.dev4tech.group2.littlegeniuses.api.controller;

import com.dev4tech.group2.littlegeniuses.api.model.request.ClassModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.request.StudentIdModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.response.ClassModelResponse;
import com.dev4tech.group2.littlegeniuses.api.modelmapper.assembler.ClassModelResponseAssembler;
import com.dev4tech.group2.littlegeniuses.api.modelmapper.disassembler.ClassModelRequestDisassembler;
import com.dev4tech.group2.littlegeniuses.api.openapi.controller.ClassControllerOpenApi;
import com.dev4tech.group2.littlegeniuses.config.security.CheckSecurity;
import com.dev4tech.group2.littlegeniuses.domain.entity.Class;
import com.dev4tech.group2.littlegeniuses.domain.entity.Student;
import com.dev4tech.group2.littlegeniuses.domain.entity.Teacher;
import com.dev4tech.group2.littlegeniuses.domain.service.ClassService;
import com.dev4tech.group2.littlegeniuses.domain.service.StudentService;
import com.dev4tech.group2.littlegeniuses.domain.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(path = "/classes")
public class ClassController implements ClassControllerOpenApi {

    @Autowired
    private ClassService classService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassModelResponseAssembler classModelResponseAssembler;

    @Autowired
    private ClassModelRequestDisassembler classModelRequestDisassembler;

    @CheckSecurity.Classes.CanConsult
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<ClassModelResponse> findAll(
            @PageableDefault(value = 10) Pageable pageable) {
        Page<Class> classes = classService.findAll(pageable);
        Page<ClassModelResponse> classModel = classModelResponseAssembler
                .toCollectionModel(classes);
        return classModel;
    }

    @CheckSecurity.Classes.CanConsult
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClassModelResponse findById(@PathVariable Long id) {
        Class c = classService.findById(id);
        return classModelResponseAssembler.toModel(c);
    }

    @CheckSecurity.Classes.CanEdit
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ClassModelResponse insert(
            @RequestBody @Valid ClassModelRequest classModelRequest) {
    	Class c = new Class();
        c.setGrade(classModelRequest.getGrade());
    	Teacher teacher = teacherService.findById(classModelRequest.getTeacherId());
    	c.setTeacher(teacher);
        c = classService.save(c);
        ClassModelResponse classModelResponse = classModelResponseAssembler.toModel(c);
        return classModelResponse;
    }

    @CheckSecurity.Classes.CanEdit
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClassModelResponse update(@PathVariable Long id,
                                     @RequestBody @Valid ClassModelRequest classModelRequest) {
        Class c = classService.findById(id);
        classModelRequestDisassembler.copyToDomainObject(classModelRequest, c);
        c = classService.save(c);
        ClassModelResponse classModelResponse = classModelResponseAssembler.toModel(c);
        return classModelResponse;
    }

    @CheckSecurity.Classes.CanEdit
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        classService.delete(id);
    }

    @PutMapping(path = "/{id}/student", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void insertStudentInClass(@PathVariable Long id,
                                     @RequestBody @Valid StudentIdModelRequest studentId) {
        Class c = classService.findById(id);
        Student s = studentService.findById(studentId.getId());
        Set<Student> students = c.getStudents();
        students.add(s);
        c.setStudents(students);
        classService.update(id, c);
    }

    @CheckSecurity.Classes.CanEdit
    @DeleteMapping("/{id}/student")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentInClass(@PathVariable Long id,
                                     @RequestBody @Valid StudentIdModelRequest student) {
        Class c = classService.findById(id);
        Student s = studentService.findById(student.getId());
        Set<Student> students = c.getStudents();
        students.remove(s);
        c.setStudents(students);
        classService.update(id, c);
    }

}
