package com.socialmedia.backend.Service;

import com.socialmedia.backend.Dto.UserDto;
import com.socialmedia.backend.Entity.User;

public interface IUserService <UserDto,Long> extends IBaseService<UserDto,Long>{
    UserDto createUser(UserDto userDto);
}
