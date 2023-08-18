package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.domain.dto.MajorRequest;
import com.example.yeoreumjava.major.domain.dto.MajorResponse;
import com.example.yeoreumjava.major.mapper.MajorMapper;
import com.example.yeoreumjava.major.repository.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MajorService {
    private final MajorRepository majorRepository;

    public List<MajorResponse> findAll() {
        List<Major> majorList = majorRepository.findAll();

        return MajorMapper.instance.toDtoList(majorList);
    }

    public MajorResponse findMajorById(Long id) {
        Major major = majorRepository.findMajorById(id);

        return MajorMapper.instance.toDto(major);
    }

    public void createMajor(MajorRequest majorRequest) {
        Major major = MajorMapper.instance.toEntity(majorRequest);

        majorRepository.save(major);
    }

    public void updateMajor(Long id, String name) {
        Major major = majorRepository.findMajorById(id);
        major.setName(name);

        majorRepository.save(major);
    }

    public void deleteMajor(Long id) {
        majorRepository.deleteById(id);
    }
}
