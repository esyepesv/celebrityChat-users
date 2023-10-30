package com.cc.users.infrastructure.adapter.output.jpa.mapper;

import com.cc.users.domain.model.User;
import com.cc.users.infrastructure.adapter.output.jpa.entity.UserEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-17T10:07:56-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class IUserEntityMapperImpl implements IUserEntityMapper {

    @Override
    public UserEntity toEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( user.getId() );
        userEntity.username( user.getUsername() );
        userEntity.email( user.getEmail() );
        userEntity.password( user.getPassword() );
        userEntity.firstName( user.getFirstName() );
        userEntity.lastName( user.getLastName() );
        if ( user.getBirthDate() != null ) {
            userEntity.birthDate( new SimpleDateFormat().format( user.getBirthDate() ) );
        }

        return userEntity.build();
    }

    @Override
    public User toUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        Long id = null;
        String username = null;
        String email = null;
        String password = null;
        String firstName = null;
        String lastName = null;
        Date birthDate = null;

        id = userEntity.getId();
        username = userEntity.getUsername();
        email = userEntity.getEmail();
        password = userEntity.getPassword();
        firstName = userEntity.getFirstName();
        lastName = userEntity.getLastName();
        try {
            if ( userEntity.getBirthDate() != null ) {
                birthDate = new SimpleDateFormat().parse( userEntity.getBirthDate() );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }

        User user = new User( id, username, email, password, firstName, lastName, birthDate );

        return user;
    }
}
