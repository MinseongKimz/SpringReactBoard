package com.side.board.application.impl;

import com.side.board.application.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardServiceImplTest {


    @Autowired
    BoardService boardService;
    @Test
    @DisplayName("서비스 - 게시물 등록 테스트")
    void insertBoard() {
 /*       BoardSaveDto boardSaveDto = new BoardSaveDto("제목", "안녕하세요컨텐츠어쩌구저저꺼구구구");

        Board saveBoard = boardService.save(boardSaveDto);

        assertEquals(saveBoard.getTitle(), "제목");
        assertEquals(saveBoard.getContent(), "안녕하세요컨텐츠어쩌구저저꺼구구구");
*/
    }

    /*@Test
    @DisplayName("서비스 - 게시물 리스트 조회")
    void getBoardsList() {
        List<BoardResponseDto> boardList = boardService.getBoards();

        for (BoardResponseDto boardResponseDto : boardList) {
            System.out.println(boardResponseDto.getId());
            System.out.println(boardResponseDto.getTitle());
            System.out.println(boardResponseDto.getRegDate());
        }
    }*/
}