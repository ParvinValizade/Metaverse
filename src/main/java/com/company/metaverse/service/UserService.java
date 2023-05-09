package com.company.metaverse.service;

import com.company.metaverse.dao.entity.User;
import com.company.metaverse.dao.repository.UserRepository;
import com.company.metaverse.mapper.UserMapper;
import com.company.metaverse.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    public UserDto createUser(UserDto request) {
        User user = userMapper.toEntity(request);
        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto findUserByPin(String pin) {
        User user = userRepository.findUserByPin(pin)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }
}
