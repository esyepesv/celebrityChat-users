package com.cc.users.aplication.handler;

import com.cc.users.aplication.dtos.UserDto;
import com.cc.users.aplication.mapper.IUserMapper;
import com.cc.users.domain.ports.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
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
    public UserDto getUser(String username) {
        return userMapper.toUserDto(userServicePort.getUser(username));
    }

    @Override
    public void updateUser(UserDto user) {
        userServicePort.updateUser(userMapper.toUser(user));
    }

    @Override
    public void deleteUser(Long id) {
        userServicePort.deleteUser(id);
    }
}
