package com.socialmedia.backend.Controller;
import com.socialmedia.backend.Dto.CommentDto;
import com.socialmedia.backend.Repository.IFriendshipRepository;
import com.socialmedia.backend.Service.Impl.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto)
    {
        CommentDto savedComment=commentService.createComment(commentDto);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public  ResponseEntity<CommentDto> getCommentById(@PathVariable("id") Long commentId)
    {
        CommentDto commentDto= commentService.getById(commentId);
        return ResponseEntity.ok(commentDto);
    }
    @GetMapping
    public ResponseEntity<List<CommentDto>>getAllComments()
    {
        List<CommentDto> commentDtos=commentService.getAll();
        return ResponseEntity.ok(commentDtos);
    }
    @PutMapping("{id}")
    public  ResponseEntity<CommentDto>updateComment(@PathVariable("id") Long commentId,@RequestBody CommentDto updatedComment)
    {
        CommentDto commentDto=commentService.update(commentId,updatedComment);
        return ResponseEntity.ok(commentDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Long commentId)
    {
       commentService.delete(commentId);
       return ResponseEntity.ok("Comment deleted succesfully");
    }
}
