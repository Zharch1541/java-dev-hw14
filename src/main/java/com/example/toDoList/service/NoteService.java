package com.example.toDoList.service;

import com.example.toDoList.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteService {

    private NoteRepository noteRepository = new NoteRepository();

    public List<Note> listAll() {
        return noteRepository.listAll();
    }

    public Note add(Note note) {
        return noteRepository.add(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        noteRepository.update(note);
    }

    public Note getById(long id) {
        return noteRepository.getById(id);
    }
}
