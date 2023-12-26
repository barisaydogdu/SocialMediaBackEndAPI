package com.socialmedia.backend.Controller;

import com.socialmedia.backend.Dto.UserDto;

import com.socialmedia.backend.Repository.IUserRepository;
import com.socialmedia.backend.Service.Impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
       // UserDto savedUser= userService.createUser(userDto);
        UserDto savedUser= userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId)
    {
      //  UserDto userDto=userService.getUserById(userId);
        UserDto userDto=userService.getById(userId);
        return ResponseEntity.ok(userDto);
    }
    //Build Get All Employees RESTFUL API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
      //  List<UserDto> employees= userService.getAllUsers();
        List<UserDto> employees= userService.getAll();
        return ResponseEntity.ok(employees);
    }
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@RequestBody UserDto updatedUser)
    {
      //  UserDto userDto=userService.updateUser(userId,updatedUser);
      UserDto userDto=userService.update(userId,updatedUser);
        return ResponseEntity.ok(userDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId)
    {
       // userService.deleteUser(userId);
        userService.delete(userId);
        return  ResponseEntity.ok("User deleted successfully");
    }


}
