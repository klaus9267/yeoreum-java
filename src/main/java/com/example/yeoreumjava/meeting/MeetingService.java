package com.example.yeoreumjava.meeting;

import com.example.yeoreumjava.meeting.domain.Apply;
import com.example.yeoreumjava.meeting.domain.Guest;
import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.ApplyRequest;
import com.example.yeoreumjava.meeting.domain.dto.MeetingRequest;
import com.example.yeoreumjava.meeting.mapper.ApplyMapper;
import com.example.yeoreumjava.meeting.mapper.HostMapper;
import com.example.yeoreumjava.meeting.mapper.MeetingMapper;
import com.example.yeoreumjava.meeting.repository.ApplyRepository;
import com.example.yeoreumjava.meeting.repository.GuestRepository;
import com.example.yeoreumjava.meeting.repository.HostRepository;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.profile.ProfileService;
import com.example.yeoreumjava.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MeetingService {
    private final MeetingRepository meetingRepository;
    private final GuestRepository guestRepository;
    private final ApplyRepository applyRepository;
    private final HostRepository hostRepository;

    private final ProfileService profileService;

    public Optional<Meeting> findMeeting(Long meetingId) {
        return meetingRepository.findById(meetingId);
    }

    @org.mapstruct.Named("loadMeeting")
    public Meeting loadMeeting(Long id) {
        return findMeeting(id).orElseThrow(() -> new NoSuchElementException(id + "번 만남이 없습니다."));
    }

    public List<Apply> loadApplyList(Long meetingId) {
        return applyRepository.findAllByMeetingId(meetingId);
    }

    public Apply loadApply(Long id) {
        return findApply(id).orElseThrow(() -> new NoSuchElementException(id + "번 신청이 없습니다."));
    }

    public Optional<Apply> findApply(Long id) {
        return applyRepository.findById(id);
    }

    public Meeting createMeeting(MeetingRequest meetingRequest) {
        Meeting meeting = MeetingMapper.instance.toEntity(meetingRequest);

        List<Host> hostList = HostMapper.instance.setEntityList(meetingRequest.getHostList(), meeting, profileService);
        hostRepository.saveAll(hostList);

        return meetingRepository.save(meeting);
    }

    public void applyMeeting(Long meetingId, ApplyRequest applyRequest) {
        Meeting meeting = loadMeeting(meetingId);

        if (meeting.isDone()) {
            throw new RuntimeException("만나 성사된 게시글 입니다.");
        }

        Apply apply = ApplyMapper.instance.toEntity(applyRequest);
        apply.setMeeting(meeting);

        applyRepository.save(apply);

        setGuestList(meeting, apply, applyRequest.getGuestList());
    }

    public void setGuestList(Meeting meeting, Apply apply, List<Long> guestIdList) {
        List<Guest> guestList = profileService.loadProfileList(guestIdList)
                                           .stream()
                                           .map(profile -> Guest.builder().meeting(meeting).team(apply).profile(profile).build())
                                           .toList();

        guestRepository.saveAll(guestList);
    }

    public void updateMeeting(Long id, MeetingRequest meetingRequest) {
        loadMeeting(id);

        Meeting meeting = MeetingMapper.instance.toEntity(meetingRequest);
        meeting.setId(id);

        meetingRepository.save(meeting);

        List<Host> hostList = HostMapper.instance.setEntityList(meetingRequest.getHostList(), meeting, profileService);
        updateHostList(id, hostList);
    }

    public void updateHostList(Long meetingId, List<Host> hostList) {
        hostRepository.deleteAllByMeetingId(meetingId);
        hostRepository.saveAll(hostList);
    }

    public void acceptApply(Long id) {
        Apply apply = loadApply(id);
        Meeting meeting = loadMeeting(apply.getMeeting().getId());
        meeting.setDone(true);

        //채팅 시작되는 api
    }
}
