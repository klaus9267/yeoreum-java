package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.dto.MajorRequest;
import com.example.yeoreumjava.major.domain.dto.MajorResponse;
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
    public ResponseEntity<List<MajorResponse>> findAll() {
        List<MajorResponse> majorRequestList = majorService.findAll();

        return ResponseEntity.ok(majorRequestList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MajorResponse> findMajorById(@PathVariable("id") Long id) {
        MajorResponse majorRequest = majorService.findMajorResponseById(id);

        return ResponseEntity.ok(majorRequest);
    }

    @PostMapping("")
    public ResponseEntity<String> createMajor(@RequestBody MajorRequest majorRequest) {
        majorService.createMajor(majorRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("생성 완료");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MajorRequest> updateMajor(@PathVariable("id") Long id, @RequestBody
    MajorRequest majorRequest) {
        majorService.updateMajor(id, majorRequest.getName());

        return ResponseEntity.ok(majorRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMajor(@PathVariable("id") Long id) {
        majorService.deleteMajor(id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 성공");
    }
}
