package com.example.yeoreumjava.meeting.repository;

import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.dto.HostResponse;
import com.example.yeoreumjava.meeting.mapper.HostMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class HostRepositoryTest {
    @Autowired
    private HostRepository hostRepository;

    @Test
    void findAllByMeeting_Id() {
        List<Host> hostList = hostRepository.findAllByMeetingId(4L);
        List<HostResponse> hostResponseList = HostMapper.instance.toDtoList(hostList);

        System.out.println(hostResponseList);

    }
}