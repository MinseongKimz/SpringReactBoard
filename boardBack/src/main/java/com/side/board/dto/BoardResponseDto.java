package com.side.board.dto;

import com.side.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    @Builder
    public  BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
        this.regDate = board.getRegDate();
        this.updateDate = board.getUpdateDate();
    }



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

}
