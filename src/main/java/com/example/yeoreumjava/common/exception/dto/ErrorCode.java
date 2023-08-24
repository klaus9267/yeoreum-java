package com.example.yeoreumjava.common.exception.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    INVALID_INPUT_VALUE(400, "COMMON-001", "유효성 검증에 실패한 경우"),
    DUPLICATE_LOGIN_ID(400, "ACCOUNT-001", "계정명이 중복된 경우"),
    CONTEST_INVALID_DATE(400, "CONTEST-001", "선정 곡 날짜가 적절치 않은 경우"),

    UNAUTHORIZED(401, "ACCOUNT-002", "인증에 실패한 경우"),

    ROLE_NOT_EXISTS(403, "ACCOUNT-004", "권한이 부족한 경우"),

    USER_NOT_FOUND(404, "USER-003", "사용자를 찾을 수 없습니다."),
    BOARD_NOT_EXISTS(404, "BOARD-005", "게시글을 찾을 수 없습니다."),
    MAJOR_NOT_FOUND(404, "MAJOR-001", "학과를 찾을 수 없습니다."),
    SONG_NOT_FOUND(404, "SONG-001", "곡을 찾을 수 없는 경우"),

    INTERNAL_SERVER_ERROR(500, "COMMON-002", "서버에서 처리할 수 없는 경우");

    private final int status;
    private final String code;
    private final String description;

}
