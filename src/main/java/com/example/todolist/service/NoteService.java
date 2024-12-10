package com.example.todolist.service;

import com.example.todolist.model.Note;
import com.example.todolist.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // Отримати всі нотатки
    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    // Додати нову нотатку
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    // Видалити нотатку за ID
    public void deleteById(long id) {
        if (!noteRepository.existsById(id)) {
            throw new NoSuchElementException("Note with ID " + id + " not found.");
        }
        noteRepository.deleteById(id);
    }

    // Оновити існуючу нотатку
    public void update(Note note) {
        if (!noteRepository.existsById(note.getId())) {
            throw new NoSuchElementException("Note with ID " + note.getId() + " not found.");
        }
        noteRepository.save(note);
    }

    // Отримати нотатку за ID
    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Note with ID " + id + " not found."));
    }
}
