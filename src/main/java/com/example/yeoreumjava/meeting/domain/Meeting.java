package com.example.yeoreumjava.meeting.domain;

import com.example.yeoreumjava.board.domain.Board;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    private String time;

    @Column(columnDefinition = "boolean default false")
    private boolean done;

    @OneToOne(mappedBy = "meeting",cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private Board board;

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private List<Host> hostList = new ArrayList<>();

    public void updateMeeting(String place, String time) {
        this.place = place;
        this.time = time;
    }
}
