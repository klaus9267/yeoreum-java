package com.example.yeoreumjava.meeting.repository;

import com.example.yeoreumjava.meeting.domain.Apply;
import com.example.yeoreumjava.meeting.domain.dto.ApplyRequest;
import com.example.yeoreumjava.meeting.mapper.ApplyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ApplyRepositoryTest {

    @Test
    void applyMapperTest() {
        List<Long> list = new ArrayList<>();
//        list.add(1L);
        list.add(2L);

        ApplyRequest applyRequest = ApplyRequest.builder()
                                                .title("test title")
                                                .content("test content")
                                                .guestList(list)
                                                .build();

        Apply apply = ApplyMapper.instance.toEntity(applyRequest);
        System.out.println(apply);
    }
}