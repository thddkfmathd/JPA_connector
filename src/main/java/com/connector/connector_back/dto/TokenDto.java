package com.connector.connector_back.dto;

import lombok.Builder;

public class TokenDto {
    private Long userId;

    @Builder
    public TokenDto(Long userId) {
        this.userId = userId;
    }
}
