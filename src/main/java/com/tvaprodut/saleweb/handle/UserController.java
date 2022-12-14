package com.tvaprodut.saleweb.handle;


import com.tvaprodut.saleweb.model.Role;
import com.tvaprodut.saleweb.model.User;
import com.tvaprodut.saleweb.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>>getUser(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users/addUser")
    public ResponseEntity<User>addUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/users/addRole")
    public ResponseEntity<Role>addRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/users/addRoletoUser")
    public ResponseEntity<Role>addtoUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(),form.getRoleName());
        return ResponseEntity.ok().build();
    }

}

@Data
class RoleToUserForm{
    private String username;
    private String roleName;
}
