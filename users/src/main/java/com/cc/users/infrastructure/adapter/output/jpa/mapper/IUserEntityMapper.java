package com.cc.users.infrastructure.adapter.output.jpa.mapper;

import com.cc.users.domain.model.User;
import com.cc.users.infrastructure.adapter.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {

    UserEntity toEntity(User user);

    User toUser(UserEntity userEntity);

}
