package com.socialmedia.backend.Dto;

import com.socialmedia.backend.Entity.Post;
import com.socialmedia.backend.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long commentId;
    private User user;
    private Post post;
    private String commentText;
    private Date commentDate;
}
