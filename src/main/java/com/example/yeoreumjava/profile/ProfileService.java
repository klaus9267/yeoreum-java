package com.example.yeoreumjava.profile;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.repository.BoardRepository;
import com.example.yeoreumjava.major.MajorService;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.profile.domain.Profile;
import com.example.yeoreumjava.profile.domain.dto.ProfileRequest;
import com.example.yeoreumjava.profile.mapper.ProfileMapper;
import com.example.yeoreumjava.profile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final MeetingRepository meetingRepository;
    private final BoardRepository boardRepository;

    private final MajorService majorService;

    @org.mapstruct.Named("loadProfile")
    public Profile loadProfile(Long id) {
        return findProfile(id).orElseThrow(() -> new NoSuchElementException(id + "번 사용자가 없습니다."));
    }

    public List<Profile> loadProfileList(List<Long> idList) {
        List<Profile> profileList = new ArrayList<>();

        idList.forEach(id -> profileList.add(loadProfile(id)));

        return profileList;
    }

    public Optional<Profile> findProfile(Long id) {
        return profileRepository.findById(id);
    }

    public Profile createProfile(ProfileRequest profileRequest) {
        Profile profile = ProfileMapper.instance.toEntity(profileRequest, majorService);

        return profileRepository.save(profile);
    }

    public Profile updateProfile(Long id, ProfileRequest profileRequest) {
        Profile user = ProfileMapper.instance.toEntity(profileRequest, majorService);
        user.setId(id);

        return profileRepository.save(user);
    }

    public void deleteProfile(Long id) {
        loadProfile(id);

        List<Board> boardList = boardRepository.findAllByWriterId(id);
        if (!boardList.isEmpty()) {
            boardList.forEach(board -> meetingRepository.deleteById(board.getMeeting().getId()));
        }

        profileRepository.deleteById(id);
    }
}
