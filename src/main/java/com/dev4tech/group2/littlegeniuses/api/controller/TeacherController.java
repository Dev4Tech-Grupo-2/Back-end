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

import com.dev4tech.group2.littlegeniuses.api.model.request.TeacherModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.response.TeacherModelResponse;
import com.dev4tech.group2.littlegeniuses.api.modelmapper.assembler.TeacherModelResponseAssembler;
import com.dev4tech.group2.littlegeniuses.api.modelmapper.disassembler.TeacherModelRequestDisassembler;
import com.dev4tech.group2.littlegeniuses.api.openapi.controller.TeacherControllerOpenApi;
import com.dev4tech.group2.littlegeniuses.domain.entity.Teacher;
import com.dev4tech.group2.littlegeniuses.domain.service.TeacherService;

@RestController
@RequestMapping(path = "/teachers")
public class TeacherController implements TeacherControllerOpenApi {

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private TeacherModelResponseAssembler teacherModelResponseAssembler;
	
	@Autowired
	private TeacherModelRequestDisassembler teacherModelRequestDisassembler;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<TeacherModelResponse> findAll(@PageableDefault(value = 10) Pageable pageable) {
		Page<Teacher> teachers = teacherService.findAll(pageable);
		Page<TeacherModelResponse> teacherModel = teacherModelResponseAssembler.toCollectionModel(teachers);
		return teacherModel;
	}
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TeacherModelResponse findById(@PathVariable Long id) {
		Teacher teacher = teacherService.findById(id);
		return teacherModelResponseAssembler.toModel(teacher);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public TeacherModelResponse insert(@RequestBody @Valid TeacherModelRequest teacherModelRequest) {
		Teacher teacher = teacherModelRequestDisassembler.toDomainObject(teacherModelRequest);
		teacher = teacherService.save(teacher);
		TeacherModelResponse teacherModelResponse = teacherModelResponseAssembler.toModel(teacher);
		return teacherModelResponse;
	}
	
	@PutMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public TeacherModelResponse update(@PathVariable Long id, @RequestBody @Valid TeacherModelRequest teacherModelRequest) {
		Teacher teacher = teacherService.findById(id);
		teacherModelRequestDisassembler.copyToDomainObject(teacherModelRequest, teacher);
		teacher = teacherService.save(teacher);
		TeacherModelResponse teacherModelResponse = teacherModelResponseAssembler.toModel(teacher);
		return teacherModelResponse;
	}
	
	@DeleteMapping(value = "/{id}", produces = {})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		teacherService.delete(id);
	}
}
