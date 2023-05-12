package com.company.metaverse.controller;

import com.company.metaverse.model.dto.UserDto;
import com.company.metaverse.model.request.UpdateUserRequest;
import com.company.metaverse.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<UserDto> getUserByPin(@RequestParam String pin) {
        return ResponseEntity.ok(userService.findUserByPin(pin));
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PutMapping("/by-pin")
    public ResponseEntity<UserDto> update(@RequestParam String pin, @RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(userService.updateUser(pin, request));
    }

    @DeleteMapping("/by-pin")
    public ResponseEntity<Void> delete(@RequestParam String pin) {
        userService.deleteUser(pin);
        return ResponseEntity.ok().build();
    }
}
