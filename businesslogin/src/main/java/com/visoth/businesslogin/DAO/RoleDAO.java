package com.visoth.businesslogin.DAO;

import com.visoth.businesslogin.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role,Integer> {
}
