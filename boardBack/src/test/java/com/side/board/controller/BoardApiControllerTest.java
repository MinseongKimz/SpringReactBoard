package com.side.board.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.side.board.dto.BoardSaveDto;
import com.side.board.repository.BoardRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class BoardApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private EntityManager entityManager;


    @Test
    @DisplayName("게시글 작성")
    public void saveBoardTest() throws Exception {

        // given
        BoardSaveDto boardSaveDto = new BoardSaveDto("제목입니다.", "내용입니다");

        String content = new ObjectMapper().writeValueAsString(boardSaveDto);

        //when, then
        ResultActions resultActions = mockMvc.perform(
                post("/api/v1/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));
        resultActions
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }







}