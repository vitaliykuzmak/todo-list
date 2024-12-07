package com.example.todolist.model;

public class Note {
    private Long id; // Унікальний ідентифікатор
    private String title; // Назва нотатки
    private String content; // Контент нотатки

    // Конструктори
    public Note() {}
    public Note(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // Геттери та сеттери
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
