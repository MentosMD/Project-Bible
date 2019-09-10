package com.backend.backend.repositories;

import com.backend.backend.models.OutputMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<OutputMessage, Long> {
}
