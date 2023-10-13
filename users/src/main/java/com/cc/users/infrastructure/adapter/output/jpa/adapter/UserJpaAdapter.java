package com.cc.users.infrastructure.adapter.output.jpa.adapter;

import com.cc.users.domain.model.User;
import com.cc.users.domain.ports.spi.IUserPersistencePort;
import com.cc.users.infrastructure.adapter.output.jpa.mapper.IUserEntitymapper;
import com.cc.users.infrastructure.adapter.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {


    private final IUserRepository userRepository;
    private final IUserEntitymapper userEntityMapper;

    @Override
    public Long saveUser(User user) {
        return userRepository.save(userEntityMapper.toEntity(user)).getId();
    }

    @Override
    public User getUser(Long id) {
        return userEntityMapper.toUser(userRepository.findById(id)
                .orElseThrow(RuntimeException::new));
    }

    @Override
    public Long updateUser(User user) {
        return userRepository.save(userEntityMapper.toEntity(user)).getId();
    }

    @Override
    public Long deleteUser(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
