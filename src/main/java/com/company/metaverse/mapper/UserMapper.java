package com.company.metaverse.mapper;

import com.company.metaverse.dao.entity.User;
import com.company.metaverse.model.dto.UserDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper extends EntityMapper<UserDto, User> {
}
