package com.cc.users.domain.ports.api;

import com.cc.users.domain.model.User;

public interface IUserServicePort {

    public Long saveUser(User user);
    public User getUser(Long id);
    public User getUser(String username);
    public void updateUser(User user);
    public void deleteUser(Long id);
}
