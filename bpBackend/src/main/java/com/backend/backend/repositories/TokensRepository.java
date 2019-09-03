package com.backend.backend.repositories;

import com.backend.backend.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokensRepository extends JpaRepository<Token, Long> {
    Optional<Token> findOneByValue(String value);

}
