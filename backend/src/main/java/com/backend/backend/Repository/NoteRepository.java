package com.backend.backend.Repository;

import com.backend.backend.model.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository  extends CrudRepository<Note, Long> {
    List<Note> findAll();
}
