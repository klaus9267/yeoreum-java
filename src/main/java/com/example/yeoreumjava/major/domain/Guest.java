package com.example.yeoreumjava.major.domain;

import com.example.yeoreumjava.meeting.domain.Meeting;

import javax.persistence.*;

@Entity
public class Guest {
    @Id
    @GeneratedValue
    private Long no;

    @ManyToOne
    @JoinColumn(name = "meeting_no")
    private Meeting meetingNo;
}
