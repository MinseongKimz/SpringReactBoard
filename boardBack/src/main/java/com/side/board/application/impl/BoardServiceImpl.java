package com.side.board.application.impl;

import com.side.board.application.BoardService;
import com.side.board.dto.BoardRequestDto;
import com.side.board.dto.BoardResponseDto;
import com.side.board.dto.ResponseDto;
import com.side.board.entity.Board;
import com.side.board.repository.BoardRepository;
import com.side.error.CustomException;
import com.side.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public ResponseDto<Object> save(BoardRequestDto boardRequestDto) {
        return ResponseDto.builder()
                .status(200)
                .message("등록 성공!")
                .data(boardRepository.save(boardRequestDto.toEntity()))
                .build();
    }

    @Override
    public ResponseDto<Object> getBoard(Long id) {
        BoardResponseDto boardResponseDto;
        try {
            boardResponseDto = new BoardResponseDto(boardRepository.getReferenceById(id));
            return ResponseDto.builder()
                    .status(200)
                    .data(boardResponseDto)
                    .build();
        } catch (Exception e) {
            log.warn("error : ", e);
            throw new CustomException(ErrorCode.POSTS_NOT_FOUND);
        }
    }

    @Override
    public ResponseDto<Object> delete(Long id) {
        try {
            Optional<Board> board = boardRepository.findById(id);
            if (board.isEmpty()) {
                return ResponseDto.builder()
                        .message("일치하는 데이터가 없습니다.")
                        .status(200)
                        .build();
            }
            boardRepository.delete(board.get());
            return ResponseDto.builder()
                    .message("삭제 성공")
                    .status(200)
                    .build();
        } catch (Exception e) {
            log.warn("error : ", e);
            throw new CustomException(ErrorCode.POSTS_NOT_FOUND);
        }
    }


    @Override
    public ResponseDto<Object> getBoards() {
        List<Board> boards = boardRepository.findAll();
        // size 0
        if (boards.isEmpty()) {
            return ResponseDto.builder()
                    .status(200)
                    .message("조회할 데이터가 없습니다.")
                    .build();
        }

        return ResponseDto.builder()
                .status(200)
                .message("boards count : " + boards.size())
                .collection(boards.stream().map(BoardResponseDto::new).collect(Collectors.toList()))
                .build();
    }

    @Override
    public ResponseDto<Object> update(Long id, BoardRequestDto boardRequestDto) {

        Optional<Board> board = boardRepository.findById(id);
        if (board.isEmpty()) {
            return ResponseDto.builder()
                    .status(200)
                    .message("올바르지 않은 ID 값 입니다.")
                    .build();
        }

        board.get().update(boardRequestDto.getTitle(), boardRequestDto.getContent(), boardRequestDto.getUpdateDate());
        return ResponseDto.builder()
                .status(200)
                .message("수정 성공")
                .data(boardRepository.save(board.get()))
                .build();
    }
}
