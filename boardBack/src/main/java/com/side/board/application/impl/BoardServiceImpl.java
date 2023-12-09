package com.side.board.application.impl;

import com.side.board.application.BoardService;
import com.side.board.dto.BoardRequestDto;
import com.side.board.dto.BoardResponseDto;
import com.side.board.dto.BoardSaveDto;
import com.side.board.entity.Board;
import com.side.board.repository.BoardRepository;
import com.side.error.CustomException;
import com.side.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public BoardResponseDto save(BoardRequestDto boardRequestDto) {
        return new BoardResponseDto(boardRepository.save(boardRequestDto.toEntity()));
    }

    @Override
    public BoardResponseDto getBoard(Long id) {
        BoardResponseDto boardResponseDto;
        try {
            boardResponseDto = new BoardResponseDto(boardRepository.getReferenceById(id));
            return boardResponseDto;
        } catch (Exception e) {
            log.warn("error : ", e);
            throw new CustomException(ErrorCode.POSTS_NOT_FOUND);
        }
    }
}
