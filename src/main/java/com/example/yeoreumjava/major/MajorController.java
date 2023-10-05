package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.dto.MajorRequest;
import com.example.yeoreumjava.major.domain.dto.MajorResponse;
import com.example.yeoreumjava.major.mapper.MajorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/majors")
@RequiredArgsConstructor
public class MajorController {
    private final MajorService majorService;

    @GetMapping("/{id}")
    public ResponseEntity<MajorResponse> loadMajor(@PathVariable("id") Long id) {
        return ResponseEntity.ok(MajorMapper.instance.toDto(majorService.loadMajor(id)));
    }

    @PostMapping("")
    public ResponseEntity<MajorResponse> createMajor(@RequestBody MajorRequest majorRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MajorMapper.instance.toDto(majorService.createMajor(majorRequest)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MajorResponse> updateMajor(@PathVariable("id") Long id,
                                                     @RequestBody MajorRequest majorRequest) {
        return ResponseEntity.ok(MajorMapper.instance.toDto(majorService.updateMajor(id, majorRequest.getName())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMajor(@PathVariable("id") Long id) {
        majorService.deleteMajor(id);

        return ResponseEntity.ok("삭제 성공");
    }
}
