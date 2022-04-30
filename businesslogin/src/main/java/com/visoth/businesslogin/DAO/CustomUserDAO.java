package com.visoth.businesslogin.DAO;

import com.visoth.businesslogin.Entity.User;
import com.visoth.businesslogin.Validate.ValidateUser;

public interface CustomUserDAO {
    public User findUsername(String name);

    public void save(User user);
}
