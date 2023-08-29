package com.example.yeoreumjava.meeting;

import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.MeetingRequest;
import com.example.yeoreumjava.meeting.domain.dto.MeetingResponse;
import com.example.yeoreumjava.meeting.mapper.HostMapper;
import com.example.yeoreumjava.meeting.mapper.MeetingMapper;
import com.example.yeoreumjava.meeting.repository.HostRepository;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class MeetingService {
    private final MeetingRepository meetingRepository;
    private final HostRepository hostRepository;
    private final UserService userService;

    public List<MeetingResponse> findAll() {
        List<Meeting> meetingList = meetingRepository.findAll();

        return MeetingMapper.instance.toDtoList(meetingList);
    }

    public MeetingResponse findMeetingResponseById(Long id) {
        Meeting meeting = meetingRepository.findById(id)
                                           .orElseThrow(() -> new NoSuchElementException(id + "번 만남이 없습니다."));

        return MeetingMapper.instance.toDto(meeting);
    }

    @org.mapstruct.Named("findMeetingById")
    public Meeting findMeetingById(Long id) {
        return meetingRepository.findById(id).orElseThrow(() -> new NoSuchElementException(id + "번 만남이 없습니다."));
    }
    public Meeting createMeeting(MeetingRequest meetingRequest) {
        Meeting meeting = MeetingMapper.instance.toEntity(meetingRequest);

        List<Host> hostList = HostMapper.instance.setEntityList(meetingRequest.getHostList(), meeting, userService);
        hostRepository.saveAll(hostList);

        sethost(2);

        return meetingRepository.save(meeting);
    }

    public void updateMeeting(Long id, MeetingRequest meetingRequest) {
        Meeting meeting = MeetingMapper.instance.toEntity(meetingRequest);
        meeting.setId(id);

        meetingRepository.save(meeting);
    }

    public void sethost(int i) {
        System.out.println(11);
    }
}
