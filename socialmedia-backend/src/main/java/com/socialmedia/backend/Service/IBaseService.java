package com.socialmedia.backend.Service;

import com.socialmedia.backend.Dto.UserDto;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Optional;

public interface IBaseService <E,ID> {

    E getById(ID userId);
    List<E> getAll();
    void delete(ID userId);
    E update(ID userId, E updatedUser);

}
