package com.backend.backend.DAO;

import com.backend.backend.model.Profile;

public interface ProfileDAO {
    boolean createProfile(Profile profile);
    boolean deleteProfile(int id);
    boolean updateProfile(Profile updatedProfile);
    Profile getProfile(int id);
}
