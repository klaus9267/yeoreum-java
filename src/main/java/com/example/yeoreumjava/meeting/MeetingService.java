package com.example.yeoreumjava.meeting;

import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import com.example.yeoreumjava.board.domain.dto.BoardResponse;
import com.example.yeoreumjava.board.repository.BoardRepository;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.MeetingRequest;
import com.example.yeoreumjava.meeting.domain.dto.MeetingResponse;
import com.example.yeoreumjava.meeting.mapper.MeetingMapper;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingService {
    private final BoardRepository boardRepository;
    private final MeetingRepository meetingRepository;

    public List<MeetingResponse> findAll() {
        List<Meeting> meetingList = meetingRepository.findAll();

        return MeetingMapper.instance.toDtoList(meetingList);
    }

    public MeetingResponse findMeetingById(Long id) {
        Meeting meeting = meetingRepository.findMeetingById(id);

        return MeetingMapper.instance.toDto(meeting);
    }
    public void createMeetingFromBoard(BoardRequest boardRequest) {
//        Meeting meeting = MeetingMapper.instance.toEntity(meetingDto);

//        meetingRepository.save(meeting);
    }

    public void updateMeeting(Long id, MeetingRequest meetingRequest) {
        Meeting meeting = MeetingMapper.instance.toEntity(meetingRequest);
        meeting.setId(id);

        meetingRepository.save(meeting);
    }


}
