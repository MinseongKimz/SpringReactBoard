package com.side.board.controller;


import com.side.board.application.BoardService;
import com.side.board.dto.BoardRequestDto;
import com.side.board.dto.BoardResponseDto;
import com.side.board.dto.BoardSaveDto;
import com.side.error.CustomException;
import com.side.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;


    // 글 생성 POST
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/board")
    public BoardResponseDto save(@RequestBody BoardRequestDto boardRequestDto) {
        if (boardRequestDto.getTitle()==null || boardRequestDto.getContent()==null)
            throw new CustomException(ErrorCode.BAD_REQUEST);
        return boardService.save(boardRequestDto);
    }

    // 글 조회 GET
    @GetMapping("/api/v1/board/{id}")
    public BoardResponseDto getBoard(@PathVariable Long id) {
        if (id==null)
            throw new CustomException(ErrorCode.BAD_REQUEST);

        return boardService.getBoard(id);
    }

    // 글 삭제
    @DeleteMapping("/api/v1/board/{id}")
    public BoardSaveDto deleteBoard(@PathVariable Long id) {
        return null;
    }

    
    // 글 수정
    @PutMapping("/api/v1/board/{id}")
    public BoardSaveDto updateBoard(@PathVariable Long id, @RequestBody BoardSaveDto boardSaveDto) {
        return null;
    }

    // 글 리스트 조회
    @GetMapping("/api/v1/boards")
    public List<BoardSaveDto> getBoards() {
        return null;
    }

}
