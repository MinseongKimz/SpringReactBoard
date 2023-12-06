package com.side.board.controller;


import com.side.board.appication.BoardService;
import com.side.board.dto.BoardSaveDto;
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
    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveDto boardSaveDto) {
        return boardService.save(boardSaveDto);
    }


}
