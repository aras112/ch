package com.comarch.comarch.dto;

import lombok.Data;


@Data
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private Boolean active = false;
    private String email;

}
