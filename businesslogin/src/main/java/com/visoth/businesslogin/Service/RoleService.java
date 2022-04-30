package com.visoth.businesslogin.Service;

import com.visoth.businesslogin.Entity.User;

import java.util.List;

public interface RoleService {
    public List<User> findAll();

    public User findById(int theId);

    public void save(User user);

    public void deleteByID(int theId);
}
