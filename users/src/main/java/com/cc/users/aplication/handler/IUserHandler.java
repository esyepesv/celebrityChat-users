package com.cc.users.aplication.handler;

import com.cc.users.aplication.dtos.UserDto;
import com.cc.users.domain.model.User;

public interface IUserHandler {
    public Long saveUser(UserDto user);
    public UserDto getUser(Long id);
    public UserDto getUser(String username);
    public void updateUser(UserDto user);
    public void deleteUser(Long id);
}
