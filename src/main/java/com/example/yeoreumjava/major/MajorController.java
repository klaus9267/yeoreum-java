package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.Major;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/majors")
@RequiredArgsConstructor
public class MajorController {
    private final MajorService majorService;
    @GetMapping("")
    public ResponseEntity<List<Major>> findAll() {
        List<Major> majors = majorService.findAll();

        return ResponseEntity.ok(majors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Major> findMajorById(@PathVariable("id") Long id) {
        Major major = majorService.findMajorById(id);

        return ResponseEntity.ok(major);
    }

    @PostMapping("")
    public ResponseEntity<Major> createMajor(@RequestBody Major major) {
        majorService.createMajor(major);

        return ResponseEntity.ok(major);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Major> updateMajor(@PathVariable("id") Long id, @RequestBody Major major) {
        majorService.updateMajor(id, major.getName());

        return ResponseEntity.ok(major);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMajor(@PathVariable("id") Long id) {
        majorService.deleteMajor(id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 성공");
    }
}
