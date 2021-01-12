package com.happn.repository;

import lombok.Builder;

@Builder
public class UserDto {

    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
}
