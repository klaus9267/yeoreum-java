package com.example.yeoreumjava.meeting.repository;

import com.example.yeoreumjava.meeting.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HostRepository extends JpaRepository<Host,Long> {
    List<Host> findAllByMeetingId(Long id);
}
