package com.backend.backend.DAOImp;

import com.backend.backend.DAO.UserDAO;
import com.backend.backend.Repository.UserRepository;
import com.backend.backend.model.User;

public class UserDAOImpl implements UserDAO {
    private UserRepository userRepository;
    @Override
    public boolean createUser() {
        return true;
    }

    @Override
    public boolean deleteUser() {
        return false;
    }

    @Override
    public User login_in() {
        return null;
    }
}
