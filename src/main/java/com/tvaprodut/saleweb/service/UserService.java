package com.tvaprodut.saleweb.service;

import com.tvaprodut.saleweb.model.Role;
import com.tvaprodut.saleweb.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getUsers();

}
