package com.example.shogi.service;

import com.example.shogi.dto.UserDto;
import java.util.List;

public interface UserService {
    void save(UserDto userDto);

    List<UserDto> findAll(Integer page, Integer size, String sort);

    UserDto findById(Long id);

    void update(UserDto userDto, Long id);


    void deleteById(Long id);
}