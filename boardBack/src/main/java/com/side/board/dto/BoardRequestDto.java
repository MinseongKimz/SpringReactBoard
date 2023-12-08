package com.side.board.dto;

import com.side.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardRequestDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    public Board toEntity() {
       return Board.builder()
               .id(id)
               .title(title)
               .content(content)
               .writer(writer)
               .regDate(regDate)
               .updateDate(updateDate)
               .build();
    }

    @Builder
    public BoardRequestDto(Long id, String title, String content, String writer, LocalDateTime regDate, LocalDateTime updateDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.regDate = regDate;
        this.updateDate = updateDate;
    }
}
