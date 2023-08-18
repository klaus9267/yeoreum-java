package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.domain.dto.MajorRequest;
import com.example.yeoreumjava.major.domain.dto.MajorResponse;
import com.example.yeoreumjava.major.mapper.MajorMapper;
import com.example.yeoreumjava.major.repository.MajorRepository;
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
        MajorRequest majorRequest = MajorRequest.builder()
                                                .name("aaaaa")
                                                .build();

        Major major = MajorMapper.instance.toEntity(majorRequest);

        majorRepository.save(major);
        majorRepository.findAll()
                       .forEach(System.out::println);
    }

    @Test
    void createMajor() {
        MajorRequest majorRequest = MajorRequest.builder().name("컴퓨타타타타").build();
        System.out.println("req : " + majorRequest);

        Major major = MajorMapper.instance.toEntity(majorRequest);
        System.out.println("entity : " + major);

        MajorResponse majorResponse = MajorMapper.instance.toDto(major);

//        majorRepository.save(major);
//        majorRepository.findAll().forEach(System.out::println);

//        System.out.println("entity : " + MajorMapper.instance.toEntity(majorRequest));
    }
}