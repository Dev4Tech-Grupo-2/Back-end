package com.dev4tech.group2.littlegeniuses.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dev4tech.group2.littlegeniuses.domain.exception.ResourceNotFoundException;
import com.dev4tech.group2.littlegeniuses.domain.repository.ClassRepository;

import com.dev4tech.group2.littlegeniuses.domain.entity.Class;

@Service
public class ClassService {

	@Autowired
	private ClassRepository classRepository;
	
	public Page<Class> findAll(Pageable pageable) {
		return classRepository.findAll(pageable);
	}
	
	public Class findById(Long classId) {
        return classRepository.findById(classId)
                .orElseThrow(() -> new ResourceNotFoundException(classId));
    }
	
	public Class save(Class c) {
        return classRepository.save(c);
    }

    public Class update(Long id, Class clas) {
        Class c = findById(id);
        BeanUtils.copyProperties(clas, c, "id");
        return save(c);
    }

    public void delete(Long id) {
    	classRepository.delete(findById(id));
    }
}
