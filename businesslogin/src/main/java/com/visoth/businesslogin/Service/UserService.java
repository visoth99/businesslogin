package com.visoth.businesslogin.Service;

import com.visoth.businesslogin.Entity.User;
import com.visoth.businesslogin.Validate.ValidateUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public List<User> findAll();

    public User findById(int theId);

    public void save(User user);

    public void deleteByID(int theId);

    public User findUsername(String name);

    public void save(ValidateUser validateUser);

}
