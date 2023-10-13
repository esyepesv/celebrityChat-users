package com.cc.users.domain.ports.api;

import com.cc.users.domain.model.User;

public interface IUserServicePort {

    public Long saveUser(User user);
    public User getUser(Long id);
    public Long updateUser(User user);
    public Long deleteUser(Long id);
}
