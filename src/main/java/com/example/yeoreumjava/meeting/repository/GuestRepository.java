package com.example.yeoreumjava.meeting.repository;

import com.example.yeoreumjava.meeting.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest,Long> {
}
