package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.Major;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MajorService {
    private final MajorRepository majorRepository;
    public List<Major> findAllMajors() {
        return majorRepository.findAll();
    }
}
