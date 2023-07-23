package com.example.yeoreumjava.meeting.domain;

import com.example.yeoreumjava.meeting.domain.Meeting;

import javax.persistence.*;

@Entity
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Meeting meeting;
}
