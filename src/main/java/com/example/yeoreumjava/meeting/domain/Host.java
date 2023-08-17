package com.example.yeoreumjava.meeting.domain;

import com.example.yeoreumjava.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Data
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Meeting meeting;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
