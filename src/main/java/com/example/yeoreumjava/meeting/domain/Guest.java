package com.example.yeoreumjava.meeting.domain;

import jakarta.persistence.*;


@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Meeting meeting;
}
