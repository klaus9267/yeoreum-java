package com.example.yeoreumjava.meeting.repository;

import com.example.yeoreumjava.meeting.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Long> {
    @org.mapstruct.Named("findGuestById")
    Guest findGuestById(Long id);
}
