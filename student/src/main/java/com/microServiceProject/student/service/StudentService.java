package com.microServiceProject.student.service;

import com.microServiceProject.student.entity.Student;
import com.microServiceProject.student.repository.StudentRepository;
import com.microServiceProject.student.vo.StudentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void saveStudent(StudentVo student) {
        studentRepository.save(Student.builder()
                .firstname(student.getFirstname())
                .lastname(student.getLastname())
                .email(student.getEmail())
                .schoolId(student.getSchoolId())
                .build());
    }

    public List<StudentVo> findAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> StudentVo.builder()
                        .id(student.getId())
                        .firstname(student.getFirstname())
                        .lastname(student.getLastname())
                        .email(student.getEmail())
                        .schoolId(student.getSchoolId())
                        .build())
                .collect(Collectors.toList());
    }
}
