package com.example.yeoreumjava.major.repository;

import com.example.yeoreumjava.major.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MajorRepository extends JpaRepository<Major,Long> {
    Major findMajorById(Long id);
//    Optional<Major> findMajorById(Long id);
}
