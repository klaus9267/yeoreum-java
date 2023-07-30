package com.example.yeoreumjava.major;

import com.example.yeoreumjava.major.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major,Long> {
    Major findMajorById(Long id);
}
