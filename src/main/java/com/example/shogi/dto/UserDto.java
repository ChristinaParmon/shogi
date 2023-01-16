package com.example.shogi.dto;


import com.example.shogi.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(setterPrefix = "set")
public class UserDto {
    private String id;
    private String username;
    private String email;
    private String phone;

    private Role role;
    private String password;
}