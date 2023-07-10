package com.user.Service.Service;

import com.user.Service.Entites.Rating;
import com.user.Service.Entites.User;
import org.springframework.data.util.Pair;


import java.util.ArrayList;
import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);
}
