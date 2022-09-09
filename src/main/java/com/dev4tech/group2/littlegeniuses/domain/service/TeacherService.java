package com.dev4tech.group2.littlegeniuses.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dev4tech.group2.littlegeniuses.domain.entity.Teacher;
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
	
	public Teacher update(Long id, Teacher teacher) {
		Teacher t = findById(id);
		BeanUtils.copyProperties(teacher, t, "id");
		return save(t);
	}
	
	public void delete(Long id) {
		teacherRepository.delete(findById(id));
	}
}
