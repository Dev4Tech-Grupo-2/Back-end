package com.dev4tech.group2.littlegeniuses.api.controller;

import com.dev4tech.group2.littlegeniuses.api.dto.StudentDTO;
import com.dev4tech.group2.littlegeniuses.domain.entity.Student;
import com.dev4tech.group2.littlegeniuses.domain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path="/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<Page<StudentDTO>> findAll(@PageableDefault(value = 10) Pageable pageable) {
		Page<StudentDTO> students = studentService
				.findAll(pageable).map(StudentDTO::new);
		return ResponseEntity.ok().body(students);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(new StudentDTO(studentService.findById(id)));
	}
	
	@PostMapping
	public ResponseEntity<StudentDTO> insert(@RequestBody @Valid StudentDTO studentDTO) {
		Student student = new Student(studentDTO);
		
		studentDTO = new StudentDTO(studentService.save(student));
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(studentDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(studentDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> update(@PathVariable Long id, @RequestBody @Valid StudentDTO studentDTO) {
		Student student = new Student(studentDTO);
		return ResponseEntity.ok().body(
				new StudentDTO(studentService.update(id, student)));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> delete(@PathVariable Long id) {
		studentService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
