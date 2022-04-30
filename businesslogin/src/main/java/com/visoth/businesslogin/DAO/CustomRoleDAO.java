package com.visoth.businesslogin.DAO;

import com.visoth.businesslogin.Entity.Role;

public interface CustomRoleDAO {
    public Role findRoleByName(String name);

}
