package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.Major;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/majors")
@RequiredArgsConstructor
public class MajorController {
    private final MajorService majorService;
    @GetMapping("/")
    public List<Major> findAllMajors() {
        return majorService.findAllMajors();
    }
}
