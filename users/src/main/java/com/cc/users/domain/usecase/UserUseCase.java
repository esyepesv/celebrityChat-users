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
    public User getUser(String username) {
        return userPersistencePort.getUser(username);
    }

    @Override
    public void updateUser(User user) {
        userPersistencePort.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userPersistencePort.deleteUser(id);
    }
}
