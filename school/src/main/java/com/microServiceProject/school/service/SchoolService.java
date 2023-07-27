package com.microServiceProject.school.service;

import com.microServiceProject.school.entity.School;
import com.microServiceProject.school.repository.SchoolRepository;
import com.microServiceProject.school.vo.SchoolVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public void saveSchool(SchoolVo school) {
        schoolRepository.save(School.builder()
                .name(school.getName())
                .email(school.getEmail())
                .build());
    }

    public List<SchoolVo> findAllSchools() {
        return schoolRepository.findAll().stream()
                .map(student -> SchoolVo.builder()
                        .id(student.getId())
                        .name(student.getName())
                        .email(student.getEmail())
                        .build())
                .collect(Collectors.toList());
    }
}
