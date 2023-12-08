package com.side.board.application;

import com.side.board.dto.BoardRequestDto;
import com.side.board.dto.BoardResponseDto;
import com.side.board.dto.BoardSaveDto;

public interface BoardService {
    BoardResponseDto save(BoardRequestDto boardRequestDto);
}
