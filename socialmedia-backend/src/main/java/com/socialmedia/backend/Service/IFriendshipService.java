package com.socialmedia.backend.Service;

import com.socialmedia.backend.Dto.FriendshipDto;
import com.socialmedia.backend.Entity.Friendship;
import com.socialmedia.backend.Service.Impl.FriendshipService;

public interface IFriendshipService <FriendshipDto,Long> extends IBaseService<FriendshipDto,Long>{

    FriendshipDto addFriend(FriendshipDto friendshipDto);



}
