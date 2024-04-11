package com.example.toDoList.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Note {
    private Long id;
    private String title;
    private String content;
}
