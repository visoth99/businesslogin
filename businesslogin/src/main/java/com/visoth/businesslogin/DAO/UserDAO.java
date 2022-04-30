package com.visoth.businesslogin.DAO;

import com.visoth.businesslogin.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
}
