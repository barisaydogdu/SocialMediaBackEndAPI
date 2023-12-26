package com.socialmedia.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "post_date")
    private Date postDate;
    @Column(name = "like_count")
    private int likeCount;
    @Column(name = "comment_count")
    private int commentCount;

}
