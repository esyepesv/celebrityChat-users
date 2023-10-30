package com.cc.users.aplication.mapper;

import com.cc.users.aplication.dtos.UserDto;
import com.cc.users.domain.model.User;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-17T10:04:20-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public User toUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        Long id = null;
        String username = null;
        String email = null;
        String password = null;
        String firstName = null;
        String lastName = null;
        Date birthDate = null;

        id = userDto.getId();
        username = userDto.getUsername();
        email = userDto.getEmail();
        password = userDto.getPassword();
        firstName = userDto.getFirstName();
        lastName = userDto.getLastName();
        birthDate = userDto.getBirthDate();

        User user = new User( id, username, email, password, firstName, lastName, birthDate );

        return user;
    }

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setBirthDate( user.getBirthDate() );

        return userDto;
    }
}
