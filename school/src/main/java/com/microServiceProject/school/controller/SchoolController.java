package com.microServiceProject.school.controller;

import com.microServiceProject.school.service.SchoolService;
import com.microServiceProject.school.vo.SchoolVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @RequestMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody SchoolVo school){
        schoolService.saveSchool(school);
    }

    @RequestMapping("/findAll")
    public ResponseEntity<List<SchoolVo>> findAllSchools(){
        return ResponseEntity.ok(schoolService.findAllSchools());
    }
}
