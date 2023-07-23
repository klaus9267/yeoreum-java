package com.example.yeoreumjava.major.domain;

import com.example.yeoreumjava.meeting.domain.Meeting;

import javax.persistence.*;

@Entity
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @ManyToOne
    @JoinColumn(name = "meeting_no")
    private Meeting meetingNo;
}
