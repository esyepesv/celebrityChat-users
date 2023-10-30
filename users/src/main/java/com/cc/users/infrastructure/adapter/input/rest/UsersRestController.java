package com.cc.users.infrastructure.adapter.input.rest;

import com.cc.users.aplication.dtos.UserDto;
import com.cc.users.aplication.handler.IUserHandler;
import com.cc.users.infrastructure.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UsersRestController {

    private final IUserHandler userHandler;

    @PostMapping("/users")
    public ResponseEntity<Long> createUser(@RequestBody UserDto user) {
        Long userId = userHandler.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userId);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            UserDto user = userHandler.getUser(id);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario no existe");
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUserByUsername(@RequestParam String username) {
        try {
            UserDto user = userHandler.getUser(username);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario no existe");
        }
    }


    @PutMapping("/users/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserDto updatedUser) {
        updatedUser.setId(id);
        userHandler.updateUser(updatedUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userHandler.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
