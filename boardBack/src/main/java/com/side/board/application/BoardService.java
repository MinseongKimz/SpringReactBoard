package com.side.board.application;

import com.side.board.dto.BoardRequestDto;
import com.side.board.dto.BoardResponseDto;
import com.side.board.dto.ResponseDto;

public interface BoardService {
    ResponseDto<Object> save(BoardRequestDto boardRequestDto);
    ResponseDto<Object> getBoard(Long id);

    ResponseDto<Object> delete(Long id);

    ResponseDto<Object> getBoards();

    ResponseDto<Object> update(Long id, BoardRequestDto boardRequestDto);
}
