package com.socialmedia.backend.Dto;

import com.socialmedia.backend.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long postId;
    private User user;
    private Date postDate;
    private String content;
    private int likeCount;
    private int commentCount;
}
