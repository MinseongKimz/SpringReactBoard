package com.side.board.dto;

import com.side.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class BoardSaveDto {
    private String title;
    private String content;
    private LocalDateTime regDate;



    @Builder
    public BoardSaveDto (String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Board toEntity() {
        return Board.builder()
                .writer("김민성")
                .content(content)
                .title(title)
                .build();
    }

    // api 요청 결과 Entity>dto로 반환하기 위해 생성자 추가
    public BoardSaveDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
        this.regDate = board.getRegDate();
    }

    protected BoardSaveDto() {
    }
}
