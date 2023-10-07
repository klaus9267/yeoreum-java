package com.example.yeoreumjava.meeting;

import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import com.example.yeoreumjava.meeting.domain.Apply;
import com.example.yeoreumjava.meeting.domain.Guest;
import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.ApplyRequest;
import com.example.yeoreumjava.meeting.mapper.ApplyMapper;
import com.example.yeoreumjava.meeting.mapper.HostMapper;
import com.example.yeoreumjava.meeting.mapper.MeetingMapper;
import com.example.yeoreumjava.meeting.repository.ApplyRepository;
import com.example.yeoreumjava.meeting.repository.GuestRepository;
import com.example.yeoreumjava.meeting.repository.HostRepository;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.profile.ProfileService;
import com.example.yeoreumjava.profile.domain.Profile;
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

    public Meeting createMeeting(BoardRequest boardRequest) {
        List<Profile> profileList = profileService.loadProfileList(boardRequest.getHostList());

        Meeting extractedMeeting = MeetingMapper.instance.extractMeeting(boardRequest);
        Meeting meeting = meetingRepository.save(extractedMeeting);

        List<Host> hostList = HostMapper.instance.setHostList(profileList, meeting);
        hostRepository.saveAll(hostList);

        return meeting;
    }

    public void updateMeeting(Long id, BoardRequest boardRequest) {
        Meeting meeting = loadMeeting(id);
        Meeting request = MeetingMapper.instance.extractMeeting(boardRequest);
        meeting.updateMeeting(request.getPlace(), request.getTime());
        meetingRepository.save(meeting);

        updateHostList(meeting, boardRequest.getHostList());
    }

    public void applyMeeting(Long meetingId, ApplyRequest applyRequest) {
        Meeting meeting = loadMeeting(meetingId);
        if (meeting.isDone()) {
            throw new RuntimeException("만나 성사된 게시글 입니다.");
        }

        Apply apply = ApplyMapper.instance.toEntity(applyRequest);
        apply.setMeeting(meeting);
        applyRepository.save(apply);

        List<Guest> guestList = profileService.loadProfileList(applyRequest.getGuestList())
                                              .stream()
                                              .map(profile -> Guest.builder()
                                                                   .meeting(meeting)
                                                                   .team(apply)
                                                                   .profile(profile)
                                                                   .build())
                                              .toList();

        guestRepository.saveAll(guestList);
    }

    public void updateHostList(Meeting meeting, List<Long> idList) {
        List<Profile> profileList = profileService.loadProfileList(idList);
        List<Host> hostList = HostMapper.instance.setHostList(profileList, meeting);

        hostRepository.deleteAllByMeetingId(meeting.getId());
        hostRepository.saveAll(hostList);
    }

    public void acceptApply(Long applyId) {
        Apply apply = loadApply(applyId);
        Meeting meeting = loadMeeting(apply.getMeeting().getId());
        meeting.setDone(true);
        meetingRepository.save(meeting);

        //채팅 시작되는 api
    }
}
