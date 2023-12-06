package com.side.board.application.impl;

import com.side.board.application.BoardService;
import com.side.board.dto.BoardSaveDto;
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
        return new BoardSaveDto(boardRepository.save(boardSaveDto.toEntity()));
    }
}
