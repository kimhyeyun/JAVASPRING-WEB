package com.example.yuncase.service;

import com.example.yuncase.constant.Role;
import com.example.yuncase.dto.BoardFormDto;
import com.example.yuncase.dto.ItemFormDto;
import com.example.yuncase.dto.ItemImgDto;
import com.example.yuncase.dto.ItemSearchDto;
import com.example.yuncase.entity.*;
import com.example.yuncase.repository.BoardRepository;
import com.example.yuncase.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

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

    @Transactional(readOnly = true)
    public BoardFormDto getBoardDtl(Long boardId){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(EntityNotFoundException::new);
        BoardFormDto boardFormDto = BoardFormDto.of(board);
        return boardFormDto;
    }

    @Transactional(readOnly = true)
    public Board findBoardItem(Long boardId){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(EntityNotFoundException::new);
        return board;
    }

    @Transactional(readOnly = true)
    public boolean validateBoardItem(Long boardId, String name) {
        Member curMember = memberRepository.findByName(name);
        Board board = boardRepository.findById(boardId)
                .orElseThrow(EntityNotFoundException::new);
        Member savedMember = board.getMember();

        if(curMember.getRole().equals(Role.ADMIN)) return true;
        if(!StringUtils.equals(curMember.getEmail(), savedMember.getEmail())) return false;

        return true;
    }

    public void deleteBoardItem(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(EntityNotFoundException::new);

        boardRepository.delete(board);
    }

    public Long updateItem(BoardFormDto boardFormDto) {
        Board board = boardRepository.findById(boardFormDto.getId())
                .orElseThrow(EntityNotFoundException::new);
        board.updateItem(boardFormDto);

        return board.getId();
    }

}
