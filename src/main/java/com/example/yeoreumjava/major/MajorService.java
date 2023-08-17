package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.domain.MajorDto;
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

    public List<MajorDto> findAll() {
        List<Major> majorList = majorRepository.findAll();

        return MajorMapper.INSTANCE.toDtoList(majorList);
    }

    public MajorDto findMajorById(Long id) {
        Major major = majorRepository.findMajorById(id);

        return MajorMapper.INSTANCE.toDto(major);
    }

    public void createMajor(MajorDto majorDTO) {
        Major major = MajorMapper.INSTANCE.toEntity(majorDTO);

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
