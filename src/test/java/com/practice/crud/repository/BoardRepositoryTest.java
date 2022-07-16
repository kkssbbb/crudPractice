package com.practice.crud.repository;

import com.practice.crud.entity.Board;
import com.practice.crud.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("게시글 더미 데이터")
    void createBoard() {

        for (int i = 0; i < 100; i++) {
            Member member = Member.builder().email("asd" + i + "@naver.com").build();

            Board board = Board.builder()
                    .title("제목" + i)
                    .content("내용" + i)
                    .writer(member)
                    .build();

            boardRepository.save(board);

        }

    }
}