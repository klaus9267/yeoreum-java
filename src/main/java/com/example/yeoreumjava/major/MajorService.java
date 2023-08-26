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

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MajorService {
    private final MajorRepository majorRepository;

    public List<MajorResponse> findAll() {
        List<Major> majorList = majorRepository.findAll();

        return MajorMapper.instance.toDtoList(majorList);
    }

    public MajorResponse findMajorResponseById(Long id) {
        Major major = majorRepository.findById(id).orElseThrow(() -> new NoSuchElementException(id + "번 전공이 없습니다."));

        return MajorMapper.instance.toDto(major);
    }

    @org.mapstruct.Named("findMajorById")
    public Major findMajorById(Long id) {
        return majorRepository.findById(id).orElseThrow(() -> new NoSuchElementException(id + "번 전공이 없습니다."));
    }

    public void createMajor(MajorRequest majorRequest) {
        Major major = MajorMapper.instance.toEntity(majorRequest);

        majorRepository.save(major);
    }

    public void updateMajor(Long id, String name) {
        Major major = majorRepository.findById(id).orElseThrow(() -> new NoSuchElementException(id + "번 전공이 없습니다."));
        major.setName(name);

        majorRepository.save(major);
    }

    public void deleteMajor(Long id) {
        majorRepository.deleteById(id);
    }
}
