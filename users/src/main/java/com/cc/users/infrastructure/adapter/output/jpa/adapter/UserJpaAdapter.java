package com.cc.users.infrastructure.adapter.output.jpa.adapter;

import com.cc.users.domain.model.User;
import com.cc.users.domain.ports.spi.IUserPersistencePort;
import com.cc.users.infrastructure.adapter.output.jpa.mapper.IUserEntityMapper;
import com.cc.users.infrastructure.adapter.output.jpa.repository.IUserRepository;
import com.cc.users.infrastructure.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {


    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public Long saveUser(User user) {
        return userRepository.save(userEntityMapper.toEntity(user)).getId();
    }

    @Override
    public User getUser(Long id) {
        return userEntityMapper.toUser(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("El usuario no existe")));
    }

    @Override
    public User getUser(String username) {
        return userEntityMapper.toUser(userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("El usuario no existe")));
    }


    @Override
    public void updateUser(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
