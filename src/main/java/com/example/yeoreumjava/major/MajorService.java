package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.domain.MajorDTO;
import com.example.yeoreumjava.major.mapper.MajorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MajorService {
    private final MajorRepository majorRepository;
    public List<MajorDTO> findAll() {
        List<Major> majors = majorRepository.findAll();

        return MajorMapper.INSTANCE.toDTOs(majors);
    }

    public MajorDTO findMajorById(Long id) {
        Major major = majorRepository.findMajorById(id);

        return MajorMapper.INSTANCE.toDTO(major);
    }

    public void createMajor(MajorDTO majorDTO) {
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
