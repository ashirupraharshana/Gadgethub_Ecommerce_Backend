package com.project.ecommerce.service;

import com.project.ecommerce.model.User;
import java.util.List;

public interface UserService {
    User registerUser(User user);
    User findByEmail(String email);
    List<User> getAllUsers();
}
