package com.backend.backend.repositories;

import com.backend.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAllByFirstName(String firstName);

    Optional<User> findOneByLogin(String login);
}
