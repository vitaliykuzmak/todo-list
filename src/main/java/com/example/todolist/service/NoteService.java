package com.example.todolist.service;

import com.example.todolist.model.Note;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    // Отримати всі нотатки
    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    // Додати нову нотатку
    public Note add(Note note) {
        long id = idGenerator.incrementAndGet();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    // Видалити нотатку за ID
    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new NoSuchElementException("Note with ID " + id + " not found.");
        }
        notes.remove(id);
    }

    // Оновити існуючу нотатку
    public void update(Note note) {
        if (!notes.containsKey(note.getId())) {
            throw new NoSuchElementException("Note with ID " + note.getId() + " not found.");
        }
        notes.put(note.getId(), note);
    }

    // Отримати нотатку за ID
    public Note getById(long id) {
        Note note = notes.get(id);
        if (note == null) {
            throw new NoSuchElementException("Note with ID " + id + " not found.");
        }
        return note;
    }
}
