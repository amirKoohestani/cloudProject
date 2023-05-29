package com.reporter.entity.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageType {
    SEND_EMAIL_MESSAGE_TYPE(0);

    private final int type;
}