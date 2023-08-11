package com.example.yeoreumjava.meeting.domain;

import com.example.yeoreumjava.board.domain.Board;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String place;
    private String time;

    @OneToOne(optional = false)
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "meeting_id")
    private List<Host> hosts = new ArrayList<>();

    @OneToMany
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "meeting_id")
    private List<Guest> guests = new ArrayList<>();
}
