package com.side.board.controller;


import com.side.board.application.BoardService;
import com.side.board.dto.BoardSaveDto;
import com.side.error.CustomException;
import com.side.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;


    // 글 생성
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/boards")
    public BoardSaveDto save(@RequestBody BoardSaveDto boardSaveDto) {
        if (boardSaveDto.getTitle()==null || boardSaveDto.getContent()==null)
            throw new CustomException(ErrorCode.BAD_REQUEST);
        return boardService.save(boardSaveDto);
    }




}
