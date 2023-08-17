package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.domain.dto.MajorDto;
import com.example.yeoreumjava.major.mapper.MajorMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MajorRepositoryTest {
    @Autowired
    private MajorRepository majorRepository;

    @Test
    void findMajorById() {
        MajorDto majorDTO = MajorDto.builder()
                                    .name("aaaaa")
                                    .build();

        Major major = MajorMapper.INSTANCE.toEntity(majorDTO);

        majorRepository.save(major);
        majorRepository.findAll()
                       .forEach(System.out::println);
    }
}