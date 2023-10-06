package com.example.yeoreumjava.profile.repository;

import com.example.yeoreumjava.profile.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
}
