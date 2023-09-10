package com.example.yeoreumjava.meeting;

import com.example.yeoreumjava.meeting.domain.Apply;
import com.example.yeoreumjava.meeting.domain.Guest;
import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.ApplyRequest;
import com.example.yeoreumjava.meeting.domain.dto.ApplyResponse;
import com.example.yeoreumjava.meeting.domain.dto.MeetingRequest;
import com.example.yeoreumjava.meeting.domain.dto.MeetingResponse;
import com.example.yeoreumjava.meeting.mapper.ApplyMapper;
import com.example.yeoreumjava.meeting.mapper.HostMapper;
import com.example.yeoreumjava.meeting.mapper.MeetingMapper;
import com.example.yeoreumjava.meeting.repository.ApplyRepository;
import com.example.yeoreumjava.meeting.repository.GuestRepository;
import com.example.yeoreumjava.meeting.repository.HostRepository;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.user.UserService;
import com.example.yeoreumjava.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class MeetingService {
    private final MeetingRepository meetingRepository;
    private final GuestRepository guestRepository;
    private final ApplyRepository applyRepository;
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

    public List<ApplyResponse> findAllAppliesByMeetingId(Long meetingId) {
        List<Apply> applyList = applyRepository.findAllByMeetingId(meetingId);

        return ApplyMapper.instance.toDtoList(applyList);
    }

    public Apply findApplyById(Long id) {
        return applyRepository.findById(id).orElseThrow(() -> new NoSuchElementException(id + "번 신청이 없습니다."));
    }

    public ApplyResponse findApplyResponseById(Long id) {
        Apply apply = findApplyById(id);

        return ApplyMapper.instance.toDto(apply);
    }

    public Meeting createMeeting(MeetingRequest meetingRequest) {
        Meeting meeting = MeetingMapper.instance.toEntity(meetingRequest);

        List<Host> hostList = HostMapper.instance.setEntityList(meetingRequest.getHostList(), meeting, userService);
        hostRepository.saveAll(hostList);

        return meetingRepository.save(meeting);
    }

    public void applyMeeting(Long meetingId, ApplyRequest applyRequest) {
        Meeting meeting = findMeetingById(meetingId);

        if (meeting.isDone()) {
            throw new RuntimeException("만나 성사된 게시글 입니다.");
        }

        Apply apply = ApplyMapper.instance.toEntity(applyRequest);
        apply.setMeeting(meeting);

        applyRepository.save(apply);

        setGuestList(meeting, apply, applyRequest.getGuestList());
    }

    public void setGuestList(Meeting meeting, Apply apply, List<Long> guestIdList) {
        List<Guest> guestList = userService.findUsersByIds(guestIdList)
                                         .stream()
                                         .map(user -> Guest.builder().meeting(meeting).team(apply).user(user).build())
                                         .toList();

        guestRepository.saveAll(guestList);
    }

    public void updateMeeting(Long id, MeetingRequest meetingRequest) {
        findMeetingById(id);

        Meeting meeting = MeetingMapper.instance.toEntity(meetingRequest);
        meeting.setId(id);

        meetingRepository.save(meeting);

        List<Host> hostList = HostMapper.instance.setEntityList(meetingRequest.getHostList(), meeting, userService);
        updateHostList(id, hostList);
    }

    public void updateHostList(Long meetingId, List<Host> hostList) {
        hostRepository.deleteAllByMeetingId(meetingId);
        hostRepository.saveAll(hostList);
    }

    public void acceptApply(Long id) {
        Apply apply = findApplyById(id);
        Meeting meeting = findMeetingById(apply.getMeeting().getId());
        meeting.setDone(true);

        //채팅 시작되는 api
    }
}
