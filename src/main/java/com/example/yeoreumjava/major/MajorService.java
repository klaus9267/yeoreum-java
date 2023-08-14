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
        return MajorMapper.INSTANCE.toDTO(majors);
    }

    public MajorDTO findMajorById(Long id) {
        return majorRepository.findMajorById(id);
    }

    public void createMajor(MajorDTO majorDTO) {
        majorRepository.save(majorDTO);
    }

    public void updateMajor(Long id, String name) {
        MajorDTO major = majorRepository.findMajorById(id);
        major.setName(name);

        majorRepository.save(major);
    }

    public void deleteMajor(Long id) {
        majorRepository.deleteById(id);
    }
}
