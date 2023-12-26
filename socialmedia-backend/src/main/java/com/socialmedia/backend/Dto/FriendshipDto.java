package com.socialmedia.backend.Dto;

import com.socialmedia.backend.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FriendshipDto {
    private Long friendshipId;
    private User user;
    private User friend;
    private String status;
}
