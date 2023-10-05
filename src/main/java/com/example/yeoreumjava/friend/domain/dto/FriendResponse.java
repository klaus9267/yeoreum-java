package com.example.yeoreumjava.friend.domain.dto;

import com.example.yeoreumjava.user.domain.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendResponse {
    private Long id;
    private User sender;
    private User receiver;
    private boolean accepted;
}
