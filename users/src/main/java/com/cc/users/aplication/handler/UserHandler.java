package com.cc.users.aplication.handler;

import com.cc.users.aplication.dtos.UserDto;
import com.cc.users.aplication.mapper.IUserMapper;
import com.cc.users.domain.ports.api.IUserServicePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserHandler implements IUserHandler{

    private final IUserServicePort userServicePort;
    private final IUserMapper userMapper;

    @Override
    public Long saveUser(UserDto user) {
        return userServicePort.saveUser(userMapper.toUser(user));
    }

    @Override
    public UserDto getUser(Long id) {
        return userMapper.toUserDto(userServicePort.getUser(id));
    }

    @Override
    public Long updateUser(UserDto user) {
        return userServicePort.updateUser(userMapper.toUser(user));
    }

    @Override
    public Long deleteUser(Long id) {
        return userServicePort.deleteUser(id);
    }
}
