package com.example.yeoreumjava.meeting.repository;

import com.example.yeoreumjava.meeting.domain.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting,Long> {
    @org.mapstruct.Named("findMeetingById")
    Meeting findMeetingById(Long id);
}
