package com.example.yeoreumjava.meeting.domain;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.major.domain.Guest;
import com.example.yeoreumjava.major.domain.Host;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String place;
    private String time;

    @OneToOne
    @JoinColumn(name = "board_no")
    private Board boardNo;

    @OneToMany
    @JoinColumn(name = "host_no")
    private List<Host> hosts = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "guest_no")
    private List<Guest> guests = new ArrayList<>();
}
