package com.example.yeoreumjava.meeting;

import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import com.example.yeoreumjava.meeting.domain.Apply;
import com.example.yeoreumjava.meeting.domain.Guest;
import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.ApplyRequest;
import com.example.yeoreumjava.meeting.mapper.ApplyMapper;
import com.example.yeoreumjava.meeting.mapper.HostMapper;
import com.example.yeoreumjava.meeting.repository.ApplyRepository;
import com.example.yeoreumjava.meeting.repository.GuestRepository;
import com.example.yeoreumjava.meeting.repository.HostRepository;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.user.UserService;
import com.example.yeoreumjava.user.domain.User;
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

    private final UserService userService;

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
        List<User> userList = userService.loadUserList(boardRequest.getHostList());
        Meeting meeting = meetingRepository.save(Meeting.builder()
                                                        .place(boardRequest.getPlace())
                                                        .time(boardRequest.getTime())
                                                        .build());
        hostRepository.saveAll(setHostList(userList, meeting));
        return meeting;
    }

    public void updateMeeting(Meeting meeting, BoardRequest boardRequest) {
        meeting.updateMeeting(boardRequest.getPlace(), boardRequest.getTime());
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

        List<Guest> guestList = userService.loadUserList(applyRequest.getGuestList())
                                              .stream()
                                              .map(user -> Guest.builder()
                                                                   .meeting(meeting)
                                                                   .team(apply)
                                                                   .user(user)
                                                                   .build())
                                              .toList();
        guestRepository.saveAll(guestList);
    }

    public void updateHostList(Meeting meeting, List<Long> hostList) {
        List<User> userList = userService.loadUserList(hostList);
        hostRepository.deleteAllByMeetingId(meeting.getId());
        hostRepository.saveAll(setHostList(userList,meeting));
    }

    public void acceptApply(Long applyId) {
        Apply apply = loadApply(applyId);
        Meeting meeting = loadMeeting(apply.getMeeting().getId());
        meeting.setDone(true);
        meetingRepository.save(meeting);

        //채팅 시작되는 api
    }

    public List<Host> setHostList(List<User> userList, Meeting meeting) {
        return userList.stream().map(user -> Host.builder().meeting(meeting).user(user).build()).toList();
    }
}
