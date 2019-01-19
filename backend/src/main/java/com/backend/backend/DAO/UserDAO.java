package com.backend.backend.DAO;

import com.backend.backend.model.User;

public interface UserDAO {
    boolean createUser();
    boolean deleteUser(int id);
    User login_in();
    User getUserById(int id);
}
