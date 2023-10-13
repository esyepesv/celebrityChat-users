package com.cc.users.domain.usecase;

import com.cc.users.domain.model.User;
import com.cc.users.domain.ports.api.IUserServicePort;
import com.cc.users.domain.ports.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public Long saveUser(User user) {
        return userPersistencePort.saveUser(user);
    }

    @Override
    public User getUser(Long id) {
        return userPersistencePort.getUser(id);
    }

    @Override
    public Long updateUser(User user) {
        return userPersistencePort.updateUser(user);
    }

    @Override
    public Long deleteUser(Long id) {
        return userPersistencePort.deleteUser(id);
    }
}
