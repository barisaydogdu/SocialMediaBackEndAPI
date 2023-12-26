package com.socialmedia.backend.Service.Impl;

import com.socialmedia.backend.Dto.FriendshipDto;
import com.socialmedia.backend.Dto.PostDto;
import com.socialmedia.backend.Dto.UserDto;
import com.socialmedia.backend.Entity.Friendship;
import com.socialmedia.backend.Entity.Post;
import com.socialmedia.backend.Entity.User;
import com.socialmedia.backend.Exception.ResourceNotFoundException;
import com.socialmedia.backend.Mapper.AutoMapper;
import com.socialmedia.backend.Repository.IPostRepository;
import com.socialmedia.backend.Service.IPostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService implements IPostService<PostDto,Long> {
    @Autowired
    AutoMapper autoMapper;
    IPostRepository postRepository;
    @Override
    public PostDto getById(Long postId) {
        Post post=postRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post does not exist with given id)"+ postId));
        return autoMapper.convertToDto(post,PostDto.class);
    }

    @Override
    public List<PostDto> getAll() {
        List<Post> posts=postRepository.findAll();
        return posts.stream().map(post -> autoMapper.convertToDto(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long userId) {
        Post post=postRepository.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("Post does not exist with given id)"));
         postRepository.deleteById(userId);

    }

    @Override
    public PostDto update(Long userId, PostDto updatedPost) {
        Post post = postRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User is not exist with given id:)" + userId));
        post.setUser(updatedPost.getUser());
        post.setPostDate(updatedPost.getPostDate());
        post.setContent(updatedPost.getContent());
        post.setLikeCount(updatedPost.getLikeCount());
        post.setCommentCount(updatedPost.getCommentCount());
        Post updatedFriendshipObj = postRepository.save(post);
        return autoMapper.convertToDto(updatedPost, PostDto.class);
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        //UserDto to user JPA Converted
        Post post=autoMapper.convertToEntity(postDto,Post.class);
        Post savedPost=postRepository.save(post);
        //User to UserDto JPA converted
        return  autoMapper.convertToDto(savedPost, PostDto.class);
    }

    @Override
    public void addLikeToPost(Long postId) {
        PostDto post=getById(postId);
        post.setLikeCount(post.getLikeCount()+1);
        Post convertedPost= autoMapper.convertToEntity(post,Post.class);
        postRepository.save(convertedPost);
    }

    @Override
    public int getLikeCount(Long postId) {
        PostDto post= getById(postId);
        return post.getLikeCount();
    }
}
