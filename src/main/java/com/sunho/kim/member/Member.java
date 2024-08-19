package com.sunho.kim.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {

    private Long id;
    private String name;
    private Grade grade;

}
