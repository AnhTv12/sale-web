package com.tvaprodut.saleweb.handle;

import com.tvaprodut.saleweb.model.Role;
import com.tvaprodut.saleweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
