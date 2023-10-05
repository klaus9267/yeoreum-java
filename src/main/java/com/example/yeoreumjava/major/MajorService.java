package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.domain.dto.MajorRequest;
import com.example.yeoreumjava.major.domain.dto.MajorResponse;
import com.example.yeoreumjava.major.mapper.MajorMapper;
import com.example.yeoreumjava.major.repository.MajorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MajorService {
    private final MajorRepository majorRepository;

    public Optional< Major> findMajor(Long id) {
        return majorRepository.findById(id);
    }

    @org.mapstruct.Named("loadMajor")
    public Major loadMajor(Long id) {
        return findMajor(id).orElseThrow(() -> new NoSuchElementException(id + "번 전공이 없습니다."));
    }

    public Major createMajor(MajorRequest majorRequest) {
        return majorRepository.save(MajorMapper.instance.toEntity(majorRequest));
    }

    public Major updateMajor(Long id, String name) {
        Major major = loadMajor(id);
        major.setName(name);

        return majorRepository.save(major);
    }

    public void deleteMajor(Long id) {
        majorRepository.deleteById(id);
    }
}
