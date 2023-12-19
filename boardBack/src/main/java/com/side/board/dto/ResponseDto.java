package com.side.board.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto<T> {
    private int status;
    private String message;
    private T data;
    private Collection<T> collection;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
