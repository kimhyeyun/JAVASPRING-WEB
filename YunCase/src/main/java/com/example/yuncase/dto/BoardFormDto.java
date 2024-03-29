package com.example.yuncase.dto;

import com.example.yuncase.entity.Board;
import com.example.yuncase.entity.Item;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class BoardFormDto {
    private Long id;
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    private String boardNm;
    @NotBlank(message = "내용은 필수 입력 값입니다.")
    private String boardDetail;

    private static ModelMapper modelMapper = new ModelMapper();

    public static BoardFormDto of(Board board) {
        BoardFormDto boardFormDto = new BoardFormDto();
        boardFormDto.id = board.getId();
        boardFormDto.boardNm = board.getBoardNm();
        boardFormDto.boardDetail = board.getBoradDetail();

        return boardFormDto;
    }
}
