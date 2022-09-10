package com.dev4tech.group2.littlegeniuses.domain.service;

import com.dev4tech.group2.littlegeniuses.domain.entity.Student;
import com.dev4tech.group2.littlegeniuses.domain.exception.BusinessException;
import com.dev4tech.group2.littlegeniuses.domain.exception.ResourceNotFoundException;
import com.dev4tech.group2.littlegeniuses.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student findById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException(studentId));
    }

    public Student save(Student student) {

        Optional<Student> studentExists = studentRepository.findByEmail(student.getEmail());

        if (studentExists.isPresent() && !studentExists.get().equals(student)) {
            throw new BusinessException(
                    String.format("There is already a registered student with the email %s", student.getEmail()));
        }

        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.delete(findById(id));
    }

}
