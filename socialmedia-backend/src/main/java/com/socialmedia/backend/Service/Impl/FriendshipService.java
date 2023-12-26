package com.socialmedia.backend.Service.Impl;

import com.socialmedia.backend.Dto.FriendshipDto;
import com.socialmedia.backend.Dto.UserDto;
import com.socialmedia.backend.Entity.Friendship;
import com.socialmedia.backend.Entity.User;
import com.socialmedia.backend.Exception.ResourceNotFoundException;
import com.socialmedia.backend.Mapper.AutoMapper;
import com.socialmedia.backend.Repository.IFriendshipRepository;
import com.socialmedia.backend.Repository.IUserRepository;
import com.socialmedia.backend.Service.IFriendshipService;
import com.socialmedia.backend.Service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FriendshipService implements IFriendshipService<FriendshipDto,Long> {

    @Autowired
    AutoMapper autoMapper;
    IFriendshipRepository friendshipRepository;
    @Override
    public FriendshipDto getById(Long userId) {
        Friendship friendship= friendshipRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("Friend does not exist with given id:" +userId));
        return  autoMapper.convertToDto(friendship,FriendshipDto.class);
    }

    @Override
    public List<FriendshipDto> getAll() {
        List<Friendship> users=friendshipRepository.findAll();

        return users.stream().map(user -> autoMapper.convertToDto(user,FriendshipDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public void delete(Long userId) {
        Friendship friendship= friendshipRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("Friendship is not exist with given id)"+userId));
        friendshipRepository.deleteById(userId);
    }

    @Override
    public FriendshipDto update(Long userId, FriendshipDto updatedUser) {
        Friendship friendship = friendshipRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User is not exist with given id:)" + userId));
        friendship.setUser(updatedUser.getUser());
        friendship.setFriend(updatedUser.getFriend());
        friendship.setStatus(updatedUser.getStatus());

        Friendship updatedFriendshipObj = friendshipRepository.save(friendship);
        return autoMapper.convertToDto(updatedUser, FriendshipDto.class);
    }

    @Override
    public FriendshipDto addFriend(FriendshipDto friendshipDto) {
        //UserDto to user JPA Converted
        Friendship user=autoMapper.convertToEntity(friendshipDto,Friendship.class);
        Friendship savedUser=friendshipRepository.save(user);
        //User to UserDto JPA converted
        return  autoMapper.convertToDto(savedUser,FriendshipDto.class);
    }


}

