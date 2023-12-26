package com.socialmedia.backend.Service.Impl;

import com.socialmedia.backend.Dto.UserDto;
import com.socialmedia.backend.Entity.User;
import com.socialmedia.backend.Exception.ResourceNotFoundException;
import com.socialmedia.backend.Mapper.AutoMapper;
import com.socialmedia.backend.Repository.IUserRepository;
import com.socialmedia.backend.Service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService<UserDto,Long> {
    @Autowired
    private IUserRepository userRepository;
    AutoMapper autoMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        //UserDto to user JPA Converted
        User user=autoMapper.convertToEntity(userDto,User.class);
        User savedUser=userRepository.save(user);
        //User to UserDto JPA converted
        return  autoMapper.convertToDto(savedUser,UserDto.class);
    }
    @Override
    public UserDto getById(Long userId) {
        User user= userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User does not exist with given id:" +userId));
        return  autoMapper.convertToDto(user,UserDto.class);
    }
    @Override
    public List<UserDto> getAll() {
        List<User> users=userRepository.findAll();

        return users.stream().map(user -> autoMapper.convertToDto(user,UserDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public UserDto update(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User is not exist with given id:)" + userId));
        user.setUserName(updatedUser.getUserName());
        user.setEmail((updatedUser.getEmail()));
        user.setPassword(updatedUser.getPassword());
        user.setFullName(updatedUser.getFullName());
        user.setProfilePicture(updatedUser.getProfilePicture());
        user.setRegistrationDate(updatedUser.getRegistrationDate());
        User updatedUserObj = userRepository.save(user);
        return autoMapper.convertToDto(updatedUser, UserDto.class);
    }
    @Override
    public void delete(Long userId) {
        User user= userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("user is not exist with given id)"+userId));
        userRepository.deleteById(userId);
    }
}