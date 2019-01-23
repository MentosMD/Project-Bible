package com.backend.backend.controllers;

import com.backend.backend.Repository.NoteRepository;
import com.backend.backend.model.Note;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/profile/note")
@CrossOrigin(origins = "*")
public class NoteController {
    private NoteRepository repos;

    @GetMapping("/{id_profile}/all")
    @ResponseBody
    public List<Note> GetAll(@PathVariable int id_profile) {
         List<Note> notes = this.repos.findAll();
         return notes;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public boolean DeleteNote(@PathVariable int id) {
        return true;
    }

    @PostMapping("/update")
    public boolean Update(Note note) {
        return true;
    }
}
