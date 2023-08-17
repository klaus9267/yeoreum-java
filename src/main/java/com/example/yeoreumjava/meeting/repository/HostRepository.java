package com.example.yeoreumjava.meeting.repository;

import com.example.yeoreumjava.meeting.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host,Long> {
    @org.mapstruct.Named("findHostById")
    Host findHostById(Long id);
}
