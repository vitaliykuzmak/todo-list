package com.example.todolist.controller;

import com.example.todolist.model.Note;
import com.example.todolist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.listAll());
        return "note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNoteForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("note", noteService.getById(id));
        return "note/edit";
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }
}

