package com.socialmedia.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private  Long userId;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private Date registrationDate;
    private String profilePicture;

}
