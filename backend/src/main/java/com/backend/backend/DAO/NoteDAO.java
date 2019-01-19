package com.backend.backend.DAO;

import com.backend.backend.model.Note;

import java.util.List;

public interface NoteDAO {
    boolean addNote(Note note);
    boolean deleteNote(int id);
    boolean updateNote(Note updatedNote);
    List<Note> getAllNotes();
}
