package com.socialmedia.backend.Service.Impl;

import com.socialmedia.backend.Dto.CommentDto;
import com.socialmedia.backend.Entity.Comment;
import com.socialmedia.backend.Exception.ResourceNotFoundException;
import com.socialmedia.backend.Mapper.AutoMapper;
import com.socialmedia.backend.Repository.ICommentRepository;
import com.socialmedia.backend.Service.ICommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentService implements ICommentService<CommentDto,Long> {
    @Autowired
    ICommentRepository commentRepository;
    AutoMapper autoMapper;
    @Override
    public CommentDto getById(Long userId) {
        Comment comment= commentRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("Comment does not exist with given id)"+userId));
        return  autoMapper.convertToDto(comment,CommentDto.class);
    }

    @Override
    public List<CommentDto> getAll() {
        List<Comment> comments= commentRepository.findAll();
        return comments.stream().map(comment -> autoMapper.convertToDto(comment, CommentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long userId) {
        Comment comment= commentRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("Comment does not exist with given id"));
        commentRepository.deleteById(userId);
    }

    @Override
    public CommentDto update(Long userId, CommentDto updatedUser) {
        Comment comment = commentRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User is not exist with given id:)" + userId));
        comment.setCommentDate(updatedUser.getCommentDate());
        comment.setCommentText(updatedUser.getCommentText());
        comment.setUser(updatedUser.getUser());
        comment.setPost(updatedUser.getPost());
        Comment updatedUserObj = commentRepository.save(comment);
        return autoMapper.convertToDto(updatedUser, CommentDto.class);
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        //Önce Entity'e çevirip save
        //Sonra tekrardan dtoya çevir
        Comment comment= autoMapper.convertToEntity(commentDto,Comment.class);
        Comment savedComment=commentRepository.save(comment);
        return autoMapper.convertToDto(savedComment,CommentDto.class);
    }
}
