package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.MajorDto;
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
    public ResponseEntity<List<MajorDto>> findAll() {
        List<MajorDto> majorDtoList = majorService.findAll();

        return ResponseEntity.ok(majorDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MajorDto> findMajorById(@PathVariable("id") Long id) {
        MajorDto majorDTO = majorService.findMajorById(id);

        return ResponseEntity.ok(majorDTO);
    }

    @PostMapping("")
    public ResponseEntity<MajorDto> createMajor(@RequestBody MajorDto majorDTO) {
        majorService.createMajor(majorDTO);

        return ResponseEntity.ok(majorDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MajorDto> updateMajor(@PathVariable("id") Long id, @RequestBody MajorDto majorDTO) {
        majorService.updateMajor(id, majorDTO.getName());

        return ResponseEntity.ok(majorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMajor(@PathVariable("id") Long id) {
        majorService.deleteMajor(id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 성공");
    }
}
