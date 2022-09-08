package com.dev4tech.group2.littlegeniuses.service;

import com.dev4tech.group2.littlegeniuses.entity.Student;
import com.dev4tech.group2.littlegeniuses.exception.ResourceNotFoundException;
import com.dev4tech.group2.littlegeniuses.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Student findById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException(studentId));
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Long id, Student student) {
        Student t = findById(id);
        BeanUtils.copyProperties(student, t, "id");
        return save(t);
    }

    public void delete(Long id) {
        studentRepository.delete(findById(id));
    }
}
