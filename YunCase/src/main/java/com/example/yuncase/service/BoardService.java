package com.example.yuncase.service;

import com.example.yuncase.dto.BoardFormDto;
import com.example.yuncase.dto.ItemSearchDto;
import com.example.yuncase.entity.*;
import com.example.yuncase.repository.BoardRepository;
import com.example.yuncase.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public Long saveBoard(BoardFormDto boardFormDto, String name) {
        Member member = memberRepository.findByName(name);
        Board board = Board.createBoard(boardFormDto, member);

        boardRepository.save(board);
        return board.getId();

    }

    @Transactional(readOnly = true)
    public Page<Board> getBoardPage(ItemSearchDto itemSearchDto, Pageable pageable) {
        return boardRepository.getBoardPage(itemSearchDto, pageable);
    }
}
