package com.example.yeoreumjava.board.domain;

import com.example.yeoreumjava.common.BaseEntity;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;

    @OneToOne(fetch = FetchType.LAZY)
    private Meeting meeting;

    public void updateBoard(String title, String content) {
        this.title = title;
        this.content = content;
    }
}


