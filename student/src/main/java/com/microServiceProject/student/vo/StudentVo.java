package com.microServiceProject.student.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Integer schoolId;
}
