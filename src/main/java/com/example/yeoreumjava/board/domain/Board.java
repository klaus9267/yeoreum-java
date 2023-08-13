package com.example.yeoreumjava.board.domain;

import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@NamedEntityGraph(name = "BoardWithMeetong",attributeNodes = @NamedAttributeNode(("meeting")))
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;

    @OneToOne(mappedBy = "board")
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @CreatedDate
    private LocalDateTime createAt;
    @LastModifiedDate
    private LocalDateTime updateAt;
}
