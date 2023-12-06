package com.side.board.appication;

import com.side.board.dto.BoardSaveDto;
import com.side.board.entity.Board;

public interface BoardService {
    BoardSaveDto save(BoardSaveDto boardSaveDto);
}
