package com.example.yeoreumjava.meeting.domain;

import jakarta.persistence.*;


@Entity
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Meeting meeting;
}
