package com.dev4tech.group2.littlegeniuses.api.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dev4tech.group2.littlegeniuses.api.dto.TeacherDTO;
import com.dev4tech.group2.littlegeniuses.domain.entity.Teacher;
import com.dev4tech.group2.littlegeniuses.domain.service.TeacherService;

@RestController
@RequestMapping(path="/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@GetMapping
	public ResponseEntity<Page<TeacherDTO>> findAll(@PageableDefault(value = 10) Pageable pageable) {
		Page<TeacherDTO> teachers = teacherService
				.findAll(pageable).map(entity -> new TeacherDTO(entity));
		return ResponseEntity.ok().body(teachers);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<TeacherDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(new TeacherDTO(teacherService.findById(id)));
	}
	
	@PostMapping
	public ResponseEntity<TeacherDTO> insert(@RequestBody @Valid TeacherDTO teacherDTO) {
		Teacher teacher = new Teacher(teacherDTO);
		
		teacherDTO = new TeacherDTO(teacherService.save(teacher));
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(teacherDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(teacherDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TeacherDTO> update(@PathVariable Long id, @RequestBody TeacherDTO teacherDTO) {
		Teacher teacher = new Teacher(teacherDTO);
		return ResponseEntity.ok().body(
				new TeacherDTO(teacherService.update(id, teacher)));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<TeacherDTO> delete(@PathVariable Long id) {
		teacherService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
