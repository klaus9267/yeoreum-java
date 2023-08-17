package com.example.yeoreumjava.meeting.repository;

import com.example.yeoreumjava.meeting.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Long> {
    Guest findGuestById(Long id);

}
