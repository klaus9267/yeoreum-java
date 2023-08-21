package com.example.yeoreumjava.meeting.domain;

import com.example.yeoreumjava.board.domain.Board;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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

    @OneToOne(mappedBy = "meeting")
    @ToString.Exclude
    @JsonIgnore
    private Board board;
}
