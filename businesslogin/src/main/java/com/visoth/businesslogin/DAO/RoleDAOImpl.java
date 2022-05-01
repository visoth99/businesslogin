package com.visoth.businesslogin.DAO;

import com.visoth.businesslogin.Entity.Role;
import com.visoth.businesslogin.Entity.User;
import com.visoth.businesslogin.Validate.ValidateUser;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class RoleDAOImpl implements CustomRoleDAO{

    @Autowired
    private EntityManager entityManager;


    @Override
    public Role findRoleByName(String name) {
        Session cSession=entityManager.unwrap(Session.class);
        Query<Role> query=cSession.createQuery("from Role where name=:roleName",Role.class);
        query.setParameter("roleName",name);
        Role role=null;
        try{
            role=query.getSingleResult();

        }catch (Exception e){
            role=null;
        }
        return role;
    }

}
