package com.example.yeoreumjava.meeting.repository;

import com.example.yeoreumjava.meeting.domain.Apply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply,Long> {
    List<Apply> findAllByMeetingId(Long id);
    Page<Apply> findAllByMeetingId(Long id, Pageable pageable);
}
