package com.example.yuncase.controller;

import com.example.yuncase.dto.BoardFormDto;
import com.example.yuncase.dto.CartItemDto;
import com.example.yuncase.dto.ItemFormDto;
import com.example.yuncase.dto.ItemSearchDto;
import com.example.yuncase.entity.Board;
import com.example.yuncase.entity.Item;
import com.example.yuncase.entity.Member;
import com.example.yuncase.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Log
@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping(value = "/board/new")
    public String boardForm(Model model) {
        model.addAttribute("boardFormDto", new BoardFormDto());
        return "/board/boardForm";
    }

    @PostMapping(value = "/board/new")
    public String boardNew(@Valid BoardFormDto boardFormDto, BindingResult bindingResult, Principal principal, Model model) {
        log.info(boardFormDto.toString());
        if(bindingResult.hasErrors()) return "board/boardForm";
        try {
            String name = principal.getName();
            boardService.saveBoard(boardFormDto, name);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", "게시물 등록 중 에러가 발생했습니다.");
            return "board/boardForm";
        }
        return "redirect:/";
    }

    @GetMapping(value = {"/board/list", "/board/list/{page}"})
    public String boardList(ItemSearchDto itemSearchDto, @PathVariable("page") Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);
        Page<Board> items = boardService.getBoardPage(itemSearchDto, pageable);
        model.addAttribute("boards", items);
        model.addAttribute("boardList", items.getContent());
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("maxPage", 10);

        return "board/boardList";
    }

    @GetMapping(value = "/board/{boardId}")
    public String boardDtl(Model model, @PathVariable("boardId") Long boardId, Principal principal) {
        if (principal == null) {
            model.addAttribute("message", "로그인이 필요합니다.");
            model.addAttribute("url", "/members/login");
            return "alert";
        }
        Board board = boardService.findBoardItem(boardId);
        model.addAttribute("board", board);

        return "board/boardDtl";
    }

    @DeleteMapping(value = "/board/delete/{boardId}")
    public @ResponseBody
    ResponseEntity deleteBoard(@PathVariable("boardId") Long boardId, Principal principal){
        if (!boardService.validateBoardItem(boardId, principal.getName())) {
            return new ResponseEntity<String>("삭제 권한이 없습니다.", HttpStatus.FORBIDDEN);
        }
        boardService.deleteBoardItem(boardId);

        return new ResponseEntity<Long>(boardId, HttpStatus.OK);
    }

    @GetMapping(value = "/board/update/{boardId}")
    public String updateBoardItem(@PathVariable("boardId") long boardId, Model model, Principal principal) {
        if (!boardService.validateBoardItem(boardId, principal.getName())) {
            model.addAttribute("message", "권한이 없습니다.");
            model.addAttribute("url", "/board/list");

            return "alert";
        }
        try {
            BoardFormDto boardFormDto = boardService.getBoardDtl(boardId);
            model.addAttribute("boardFormDto", boardFormDto);
        } catch (EntityNotFoundException e) {
            model.addAttribute("errorMessage", "존재하지 않는 게시글입니다.");
            model.addAttribute("boardFormDto", new BoardFormDto());

            return "board/boardForm";
        }
        return "board/boardForm";
    }

    @PostMapping(value = "/board/update/{boardId}")
    public String UpdateDoardItem(@Valid BoardFormDto boardFormDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) return "board/boardForm";
        try {
            boardService.updateItem(boardFormDto);
            Board board = boardService.findBoardItem(boardFormDto.getId());
            model.addAttribute("board", board);
            return "board/boardDtl";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "게시글 수정 중 에러가 발생했습니다.");
            return "board/boardForm";
        }
    }

}
