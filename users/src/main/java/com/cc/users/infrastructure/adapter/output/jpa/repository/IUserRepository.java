package com.cc.users.infrastructure.adapter.output.jpa.repository;

import com.cc.users.infrastructure.adapter.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
}
