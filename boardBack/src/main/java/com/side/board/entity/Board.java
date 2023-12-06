package com.side.board.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;
    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

    @Builder
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }
}