package com.tvaprodut.saleweb;

import com.tvaprodut.saleweb.model.Role;
import com.tvaprodut.saleweb.model.User;
import com.tvaprodut.saleweb.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SaleWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaleWebApplication.class, args);
    }
//    @Bean
//    CommandLineRunner run(UserService userService){
//        return args -> {
//            userService.saveRole(new Role(null,"ROLE_USER"));
//            userService.saveRole(new Role(null,"ROLE_ADMIN"));
//            userService.saveRole(new Role(null,"ROLE_MANAGER"));
//            userService.saveRole(new Role(null,"ROLE_9999"));
//
//            userService.saveUser(new User(null,"Viet Anh","taanh","51196",new ArrayList<>()));
//            userService.saveUser(new User(null,"Diem","diem2000","51196",new ArrayList<>()));
//            userService.saveUser(new User(null,"Ngoc Huyen","huyen2007","51196",new ArrayList<>()));
//
//            userService.addRoleToUser("taanh","ROLE_MANAGER");
//            userService.addRoleToUser("taanh","ROLE_ADMIN");
//            userService.addRoleToUser("taanh","ROLE_USER");
//            userService.addRoleToUser("diem2000","ROLE_USER");
//            userService.addRoleToUser("huyen2007","ROLE_USER");
//
//        };
//    }

}
