package com.side.board.appication.impl;

import com.side.board.appication.BoardService;
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
    public Long save(BoardSaveDto boardSaveDto) {
        return boardRepository.save(boardSaveDto.toEntity()).getId();
    }
}
