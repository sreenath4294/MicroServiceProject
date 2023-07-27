package com.microServiceProject.student.controller;

import com.microServiceProject.student.service.StudentService;
import com.microServiceProject.student.vo.StudentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @RequestMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody StudentVo student){
        studentService.saveStudent(student);
    }

    @RequestMapping("/findAll")
    public ResponseEntity<List<StudentVo>> findAllStudents(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }
}
