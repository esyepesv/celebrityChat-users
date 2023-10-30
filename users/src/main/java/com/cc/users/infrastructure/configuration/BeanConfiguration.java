package com.cc.users.infrastructure.configuration;

import com.cc.users.domain.ports.api.IUserServicePort;
import com.cc.users.domain.ports.spi.IUserPersistencePort;
import com.cc.users.domain.usecase.UserUseCase;
import com.cc.users.infrastructure.adapter.output.jpa.adapter.UserJpaAdapter;
import com.cc.users.infrastructure.adapter.output.jpa.mapper.IUserEntityMapper;
import com.cc.users.infrastructure.adapter.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    public final IUserRepository userRepository;
    public final IUserEntityMapper userEntityMapper;



    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort());
    }

}
