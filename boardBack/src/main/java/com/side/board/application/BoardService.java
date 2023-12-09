package com.side.board.application;

import com.side.board.dto.BoardRequestDto;
import com.side.board.dto.BoardResponseDto;
import com.side.board.dto.BoardSaveDto;

import java.util.List;

public interface BoardService {
    BoardResponseDto save(BoardRequestDto boardRequestDto);
    BoardResponseDto getBoard(Long id);

    void delete(Long id);

    List<BoardResponseDto> getBoards();
}
