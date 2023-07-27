package com.microServiceProject.school.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SchoolVo {

    private Integer id;
    private String name;
    private String lastname;
    private String email;
}
