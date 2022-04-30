package com.visoth.businesslogin.Service;

import com.visoth.businesslogin.DAO.CustomRoleDAO;
import com.visoth.businesslogin.DAO.CustomUserDAO;
import com.visoth.businesslogin.DAO.UserDAO;
import com.visoth.businesslogin.Entity.Role;
import com.visoth.businesslogin.Entity.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.visoth.businesslogin.Validate.ValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private CustomUserDAO userDAO;

    @Autowired
    private UserDAO useDD;
    @Autowired
    private CustomRoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return useDD.findAll();
    }

    @Override
    public User findById(int theId) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void deleteByID(int theId) {

    }

    @Override
    @Transactional
    public User findUsername(String name) {

        return userDAO.findUsername(name);
    }

    @Override
    @Transactional
    public void save(ValidateUser validateUser) {
        User user=new User();
        user.setPassword(passwordEncoder.encode(validateUser.getPassword()));
        user.setFirstName(validateUser.getFirstName());
        user.setLastName(validateUser.getLastName());
        user.setEmail(validateUser.getEmail());

        user.setRoles(Arrays.asList(roleDAO.findRoleByName("OFFICER")));
        userDAO.save(user);

    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDAO.findUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
       return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
