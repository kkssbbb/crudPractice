package com.practice.crud.service;

import com.practice.crud.dto.BoardDTO;
import com.practice.crud.entity.Board;
import com.practice.crud.entity.Member;

public interface BoardService {
    //게시글 등록은 BoardDTO를 파라미터로 받아 생성된 게시물의 번호를 반환하도록 한다.
    //BoardDTO -> BoardEntity 변환
    Long legister(BoardDTO boardDTO);

    default Board dtoToEntity(BoardDTO boardDTO){

        Member member = Member.builder().email(boardDTO.getWriterEmail()).build();

        Board board = Board.builder()
                .bno(boardDTO.getBno())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(member)
                .build();

        return  board;

    }
}
