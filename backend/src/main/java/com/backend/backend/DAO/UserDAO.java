package com.backend.backend.DAO;

import com.backend.backend.model.User;

public interface UserDAO {
    boolean createUser();
    boolean deleteUser();
    User login_in();
}
