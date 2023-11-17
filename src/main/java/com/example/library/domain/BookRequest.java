package com.example.library.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class BookRequest {
    @Id
    int num;
    @Column(nullable = false)
    int date;
    @Column(nullable = false)
    String name;
    String writer;
    String explanation;
}
