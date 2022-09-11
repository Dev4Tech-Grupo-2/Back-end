package com.dev4tech.group2.littlegeniuses.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dev4tech.group2.littlegeniuses.domain.entity.Teacher;
import com.dev4tech.group2.littlegeniuses.domain.exception.ForeignKeyException;
import com.dev4tech.group2.littlegeniuses.domain.exception.ResourceNotFoundException;
import com.dev4tech.group2.littlegeniuses.domain.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	public Page<Teacher> findAll(Pageable pageable) {
		return teacherRepository.findAll(pageable);
	}
	
	public Teacher findById(Long teacherId) {
		return teacherRepository.findById(teacherId)
				.orElseThrow(() -> new ResourceNotFoundException(teacherId));
	}
	
	public Teacher save(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	public void delete(Long id) {
		try {
			teacherRepository.delete(findById(id));
		} catch (DataIntegrityViolationException e) {
			throw new ForeignKeyException(id);
		}
	}
}
