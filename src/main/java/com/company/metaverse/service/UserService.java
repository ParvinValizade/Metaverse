package com.company.metaverse.service;

import com.company.metaverse.dao.entity.User;
import com.company.metaverse.dao.repository.UserRepository;
import com.company.metaverse.mapper.UserMapper;
import com.company.metaverse.model.dto.UserDto;
import com.company.metaverse.model.request.UpdateUserRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Transactional
    public UserDto createUser(UserDto request) {
        User user = userMapper.toEntity(request);
        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto findUserByPin(String pin) {
        User user = userRepository.findUserByPin(pin)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }

    public List<UserDto> getAllUser() {
        return userMapper.toDto(userRepository.findAll());
    }

    @Transactional
    public UserDto updateUser(String pin, UpdateUserRequest request) {
        User user = findByPin(pin);
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        user.setAge(request.getAge());
        user.setEmail(request.getEmail());
       return userMapper.toDto(userRepository.save(user));
    }

    @Transactional
    public void deleteUser(String pin) {
        User user = findByPin(pin);
        userRepository.delete(user);
    }
    private User findByPin(String pin) {
        return userRepository.findUserByPin(pin)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
