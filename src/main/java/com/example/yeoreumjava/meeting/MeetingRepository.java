package com.example.yeoreumjava.meeting;

import com.example.yeoreumjava.meeting.domain.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting,Long> {
}
