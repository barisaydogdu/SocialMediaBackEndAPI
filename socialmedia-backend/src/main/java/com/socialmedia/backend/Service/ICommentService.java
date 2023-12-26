package com.socialmedia.backend.Service;

import com.socialmedia.backend.Entity.Comment;

public interface ICommentService <CommentDto,Long> extends IBaseService<CommentDto,Long>{
        CommentDto createComment(CommentDto commentDto);
}
