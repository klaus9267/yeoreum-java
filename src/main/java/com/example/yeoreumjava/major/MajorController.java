package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.MajorDTO;
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
    public ResponseEntity<List<MajorDTO>> findAll() {
        List<MajorDTO> majors = majorService.findAll();

        return ResponseEntity.ok(majors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MajorDTO> findMajorById(@PathVariable("id") Long id) {
        MajorDTO major = majorService.findMajorById(id);

        return ResponseEntity.ok(major);
    }

    @PostMapping("")
    public ResponseEntity<MajorDTO> createMajor(@RequestBody MajorDTO majorDTO) {
        majorService.createMajor(majorDTO);

        return ResponseEntity.ok(majorDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MajorDTO> updateMajor(@PathVariable("id") Long id, @RequestBody MajorDTO majorDTO) {
        majorService.updateMajor(id, majorDTO.getName());

        return ResponseEntity.ok(majorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMajor(@PathVariable("id") Long id) {
        majorService.deleteMajor(id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 성공");
    }
}
