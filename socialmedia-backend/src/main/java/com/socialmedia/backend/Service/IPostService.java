package com.socialmedia.backend.Service;

import com.socialmedia.backend.Entity.Post;

public interface IPostService <PostDto,Long> extends IBaseService<PostDto,Long>{
    PostDto createPost(PostDto postDto);
    void addLikeToPost(Long postId);
    int getLikeCount(Long postId);

}
