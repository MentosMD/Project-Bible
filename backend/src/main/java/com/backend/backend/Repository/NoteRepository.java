package com.backend.backend.Repository;

import com.backend.backend.model.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository  extends CrudRepository<Note, Long> {
    List<Note> findAll();
    Note findById(int id);

    @Query("select Id from Note where Id = :id")
    boolean deleteById(@Param("id") int id);
}
