package com.example.yeoreumjava.meeting;

import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.mapper.HostMapper;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MeetingServiceTest {
    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private UserService userService;

    @Test
    void mapperTest() {
        Meeting meeting = meetingRepository.findById(1L).orElseThrow(RuntimeException::new);

        List<Long> hostList = new ArrayList<>();
        hostList.add(4L);
        hostList.add(5L);
        hostList.add(6L);

//        List<Host> hosts = HostMapper.instance.setEntityList(hostList, meeting, userService);
//        System.out.println(">>>> : " + hosts);

    }
}