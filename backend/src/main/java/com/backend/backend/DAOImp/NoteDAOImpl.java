package com.backend.backend.DAOImp;

import com.backend.backend.DAO.NoteDAO;
import com.backend.backend.model.Note;

import java.util.List;

public class NoteDAOImpl implements NoteDAO {

    @Override
    public boolean addNote(Note note) {
        return false;
    }

    @Override
    public boolean deleteNote(int id) {
        return false;
    }

    @Override
    public boolean updateNote(Note updatedNote) {
        return false;
    }

    @Override
    public List<Note> getAllNotes() {
        return null;
    }
}
