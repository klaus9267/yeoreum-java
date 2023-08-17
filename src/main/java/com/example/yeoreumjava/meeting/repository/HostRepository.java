package com.example.yeoreumjava.meeting.repository;

import com.example.yeoreumjava.meeting.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host,Long> {
    Host findHostById(Long id);
}
