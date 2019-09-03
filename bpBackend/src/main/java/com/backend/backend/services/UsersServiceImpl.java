package com.backend.backend.services;

import com.backend.backend.forms.ProfileForm;
import com.backend.backend.forms.UserForm;
import com.backend.backend.models.Role;
import com.backend.backend.models.State;
import com.backend.backend.models.User;
import com.backend.backend.models.exeptions.UserNotFoundException;
import com.backend.backend.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final PasswordEncoder passwordEncoder;

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(PasswordEncoder passwordEncoder, UsersRepository usersRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = usersRepository;
    }

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .hashPassword(hashPassword)
                .login(userForm.getLogin())
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();

        usersRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public User getUser(long userId) throws UserNotFoundException {
        Optional<User> userCandidate = usersRepository.findById(userId);
        if (userCandidate.isPresent()) {
            return userCandidate.get();
        }
        throw new UserNotFoundException("User not found for id: " + userId);
    }

    @Override
    public User updateUser(ProfileForm profileForm, long userId) throws UserNotFoundException {
         usersRepository.findById(userId)
                .map(newUserProfile -> {
                    newUserProfile.setFirstName(profileForm.getFirstName());
                    newUserProfile.setLastName(profileForm.getLastName());
                    newUserProfile.setLogin(profileForm.getLogin());
                    return usersRepository.save(newUserProfile);
                });
        Optional<User> userCandidate = usersRepository.findById(userId);
        if (userCandidate.isPresent()) {
            return userCandidate.get();
        }
        throw new UserNotFoundException("could not update User");
    }
}
