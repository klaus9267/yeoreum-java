package com.example.yeoreumjava.meeting.domain;

import com.example.yeoreumjava.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Apply extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = true)
    private boolean isAccepted;

    @ManyToOne(fetch = FetchType.LAZY)
    private Meeting meeting;

    @OneToMany(mappedBy = "team")
    private List<Guest> guestList = new ArrayList<>();
}
