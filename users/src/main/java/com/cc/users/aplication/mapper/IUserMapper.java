package com.cc.users.aplication.mapper;

import com.cc.users.aplication.dtos.UserDto;
import com.cc.users.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    public User toUser(UserDto userDto);
    public UserDto toUserDto(User user);
}
