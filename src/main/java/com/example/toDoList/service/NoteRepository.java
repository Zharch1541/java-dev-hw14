package com.example.toDoList.service;

import com.example.toDoList.entity.Note;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class NoteRepository {
    private List<Note> noteList = new ArrayList<>();
    public Random random = new Random();


    public List<Note> listAll() {
        return this.noteList;
    }

    public Note add(Note note) {
        note.setId(random.nextLong());
        this.noteList.add(note);
        return note;
    }

    public void deleteById(long id) {
        for (Note note : noteList) {
            if (note.getId() == id) {
                noteList.remove(note);
            }
        }
        throw new IllegalArgumentException("Note with id " + id + " not found");
    }

    public void update(Note note) {
        Long id = note.getId();
        for (Note existingNote : noteList) {
            if (existingNote.getId() == id) {
                existingNote.setTitle(note.getTitle());
                existingNote.setContent(note.getContent());
                return;
            }
        }
        throw new IllegalArgumentException("Note with id " + id + " not found");
    }


    public Note getById(long id) {
        for (Note note : noteList) {
            if (note.getId() == id) {
                return note;
            }
        }
        throw new IllegalArgumentException("Note with id" + id + " not found");
    }
}
