package com.side.board.appication.impl;

import com.side.board.appication.BoardService;
import com.side.board.dto.BoardSaveDto;
import com.side.board.entity.Board;
import com.side.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public BoardSaveDto save(BoardSaveDto boardSaveDto) {
        BoardSaveDto resultBoardDto = new BoardSaveDto(boardRepository.save(boardSaveDto.toEntity()));
        return resultBoardDto;
    }
}
