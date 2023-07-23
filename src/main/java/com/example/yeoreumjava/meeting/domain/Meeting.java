package com.example.yeoreumjava.meeting.domain;

import com.example.yeoreumjava.board.domain.Board;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String place;
    private String time;

    @OneToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany
    @JoinColumn(name = "meeting_id")
    private List<Host> hosts = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "meeting_id")
    private List<Guest> guests = new ArrayList<>();
}
