package com.example.toDoList.service;

import com.example.toDoList.entity.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoteServiceTest {

    private NoteService noteService;

    @BeforeEach
    public void beforeEach() {
        noteService = new NoteService();
    }

    @Test
    public void listAllTest() {
        Note note1 = new Note();
        note1.setTitle("Note1");
        note1.setContent("This is note1");
        Note note2 = new Note();
        note2.setTitle("Note2");
        note2.setContent("This is note2");

        List<Note> expectedNotes = new ArrayList<>();
        expectedNotes.add(note1);
        expectedNotes.add(note2);

        noteService.add(note1);
        noteService.add(note2);

        List<Note> actualNotes = noteService.listAll();

        Assertions.assertEquals(expectedNotes, actualNotes);
    }

    @Test
    public void addTest() {
        Note note = new Note();
        note.setTitle("Test Note");
        note.setContent("Test content");

        Note addedNote = noteService.add(note);

        Assertions.assertEquals(note.getTitle(), addedNote.getTitle());
        Assertions.assertEquals(note.getContent(), addedNote.getContent());
    }

    @Test
    public void deleteByIdTest() {
        Long incorrectId = 1598L;
        Assertions.assertThrows(IllegalArgumentException.class, () -> noteService.deleteById(incorrectId));
    }

    @Test
    public void update() {
        Note note = new Note();
        note.setTitle("Test Note");
        note.setContent("Test content");
        Note addedNote = noteService.add(note);

        long noteId = addedNote.getId();

        String updatedTitle = "Updated Note";
        String updatedContent = "Updated content";

        addedNote.setTitle(updatedTitle);
        addedNote.setContent(updatedContent);

        noteService.update(addedNote);

        Note updatedNote = noteService.getById(noteId);
        Assertions.assertEquals(updatedTitle, updatedNote.getTitle());
        Assertions.assertEquals(updatedContent, updatedNote.getContent());
        Assertions.assertThrows(IllegalArgumentException.class, () -> noteService.getById(1000));
    }

    @Test
    public void getById() {
        Note note = new Note();
        note.setTitle("Test Note");
        note.setContent("Test content");
        Note addedNote = noteService.add(note);

        long noteId = addedNote.getId();

        Assertions.assertEquals(addedNote, noteService.getById(noteId));
        Assertions.assertThrows(IllegalArgumentException.class, () -> noteService.getById(999));
    }
}