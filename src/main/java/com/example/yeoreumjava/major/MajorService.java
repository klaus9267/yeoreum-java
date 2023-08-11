package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.Major;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MajorService {
    private final MajorRepository majorRepository;
    public List<Major> findAll() {
        return majorRepository.findAll();
    }

    public Major findMajorById(Long id) {
        return majorRepository.findMajorById(id);
    }

    public void createMajor(Major major) {
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
