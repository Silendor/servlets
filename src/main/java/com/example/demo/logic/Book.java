package com.example.demo.logic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String name;
    private String author;
    private int quantity;

    public Book(String name, String author, int quantity) {
        this.name = name;
        this.author = author;
        this.quantity = quantity;
    }
}
