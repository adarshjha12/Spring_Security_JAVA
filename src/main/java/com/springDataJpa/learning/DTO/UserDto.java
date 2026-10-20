package com.springDataJpa.learning.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"id", "name", "email"})

public class UserDto {
    private  Long id;
    private String name;
    private String email;

}
