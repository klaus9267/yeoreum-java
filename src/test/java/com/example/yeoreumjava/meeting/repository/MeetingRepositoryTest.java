package com.example.yeoreumjava.meeting.repository;

import com.example.yeoreumjava.meeting.domain.Meeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MeetingRepositoryTest {
    @Autowired private MeetingRepository meetingRepository;

    @Test
    void createMeeting() {
        Meeting meeting = Meeting.builder().place("원하는 곳").time("원할 때").build();
        Meeting s = meetingRepository.save(meeting);

        System.out.println("new board : " + s);
    }
}