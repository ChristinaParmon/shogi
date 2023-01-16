package com.example.shogi.service;


import com.example.shogi.dto.UserDto;
import com.example.shogi.mapper.UserMapper;
import com.example.shogi.models.User;
import com.example.shogi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public void save(UserDto userDto) {
        Optional.ofNullable(userDto)
                .map(userMapper::toEntity)
                .map(userRepository::save);
    }

    @Override
    public List<UserDto> findAll(Integer page, Integer size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return userRepository.findAll(pageable).stream().map(userMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public UserDto findById(Long id) {
        return Optional.ofNullable(id)
                .flatMap(userRepository::findById)
                .map(userMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void update(UserDto userDto, Long id) {
        Optional.ofNullable(id)
                .filter(userRepository::existsById)
                .map(it -> {
                    User user = userMapper.toEntity(userDto);
                    user.setId(it);
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @Override
    public void deleteById(Long id) {
        Optional.ofNullable(id)
                .filter(userRepository::existsById)
                .ifPresentOrElse(userRepository::deleteById, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                });

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.singleton(user.getRole())))
                .orElseThrow(()->new UsernameNotFoundException("Failed to retrieve user" + username));
    }
}
