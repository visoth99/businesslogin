package com.visoth.businesslogin.DAO;

import com.visoth.businesslogin.Entity.User;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDAOImpl implements CustomUserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public User findUsername(String name) {
        Session cSession=entityManager.unwrap(Session.class);
        Query<User> query=cSession.createQuery("from User where userName=:userName",User.class);
        query.setParameter("userName",name);

        User user=null;
        try{
            user=query.getSingleResult();
        }catch (Exception e){
            user=null;
        }
        return user;
    }

    @Override
    public void save(User user) {
        Session cSession=entityManager.unwrap(Session.class);
        cSession.saveOrUpdate(user);
    }
}
