package com.org.ags.mapper;

import com.org.ags.entity.UserEntity;
import com.org.ags.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "useId", source = "userEntity.id")
    public User entityToModel(UserEntity userEntity);
    @Mapping(target = "id", source = "user.userId")
    public UserEntity modelToEntity(User user);
}
