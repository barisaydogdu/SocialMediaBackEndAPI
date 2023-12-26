package com.socialmedia.backend.Controller;

import com.socialmedia.backend.Dto.PostDto;
import com.socialmedia.backend.Repository.IPostRepository;
import com.socialmedia.backend.Service.Impl.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto)
    {
        PostDto savedPost=postService.createPost(postDto);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts()
    {
        List<PostDto> posts= postService.getAll();
        return ResponseEntity.ok(posts);
    }
    @GetMapping("{id}")
    public ResponseEntity<PostDto> getUserById(@PathVariable("id") Long userId)
    {
        PostDto postDto=postService.getById(userId);
        return ResponseEntity.ok(postDto);
    }
    @PutMapping("{id}")
    public ResponseEntity<PostDto> updateUser(@PathVariable("id") Long userId,@RequestBody PostDto updatedPost)
    {
        PostDto postDto=postService.update(userId,updatedPost);
        return ResponseEntity.ok(postDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId)
    {
        postService.delete(userId);
        return  ResponseEntity.ok("User deleted successfully");
    }
    @PostMapping("/{postId}/like")
    public ResponseEntity<Void> addLikeToPost(@PathVariable Long postId)
    {
     postService.addLikeToPost(postId);
     return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{postId}/likes")
    public ResponseEntity<Integer> getLikeCount(@PathVariable Long postId) {
        int likeCount = postService.getLikeCount(postId);
        return new ResponseEntity<>(likeCount, HttpStatus.OK);
    }
}
