package com.example.yeoreumjava.user.domain;

import com.example.yeoreumjava.major.domain.Major;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String nickname;
    private Major major_id;
}
