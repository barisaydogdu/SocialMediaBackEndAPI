package com.socialmedia.backend.Controller;
import com.socialmedia.backend.Dto.FriendshipDto;
import com.socialmedia.backend.Repository.IFriendshipRepository;
import com.socialmedia.backend.Service.Impl.FriendshipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/friendships")
public class FriendshipController {
    private FriendshipService friendshipService;
    @PostMapping
    public ResponseEntity<FriendshipDto> createFriendship(@RequestBody FriendshipDto friendshipDto)
    {
        // UserDto savedUser= userService.createUser(userDto);
        FriendshipDto savedFriendship= friendshipService.addFriend(friendshipDto);
        return new ResponseEntity<>(savedFriendship, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<FriendshipDto> getFriendshipById(@PathVariable("id") Long userId)
    {
        FriendshipDto friendshipDto=friendshipService.getById(userId);
        return ResponseEntity.ok(friendshipDto);
    }
    @GetMapping
    public ResponseEntity<List<FriendshipDto>> getAllFriendships()
    {
        List<FriendshipDto> friendshipDtos= friendshipService.getAll();
        return ResponseEntity.ok(friendshipDtos);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteFriendship(@PathVariable("id") Long userId)
    {
        friendshipService.delete(userId);
        return ResponseEntity.ok("Friendship deleted succesfuly");
    }
    @PutMapping("{id}")
    public  ResponseEntity<FriendshipDto> updateFriendship(@PathVariable("id") Long userId,@RequestBody FriendshipDto updatedFriendship)
    {
        FriendshipDto friendshipDto=friendshipService.update(userId,updatedFriendship);
        return ResponseEntity.ok(friendshipDto);
    }
}
