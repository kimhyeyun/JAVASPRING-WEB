package com.example.yuncase.controller;

import com.example.yuncase.dto.BoardFormDto;
import com.example.yuncase.dto.CartItemDto;
import com.example.yuncase.dto.ItemFormDto;
import com.example.yuncase.dto.ItemSearchDto;
import com.example.yuncase.entity.Board;
import com.example.yuncase.entity.Item;
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

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Log
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping(value = "/new")
    public String boardForm(Model model) {
        model.addAttribute("boradFormDto", new BoardFormDto());
        return "/board/boardForm";
    }

    @PostMapping(value = "/new")
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

    @GetMapping(value = {"/list", "/list/{page}"})
    public String boardList(ItemSearchDto itemSearchDto, @PathVariable("page") Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);
        Page<Board> items = boardService.getBoardPage(itemSearchDto, pageable);
        model.addAttribute("boards", items);
        model.addAttribute("boardList", items.getContent());
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("maxPage", 10);

        return "board/boardList";
    }
}
