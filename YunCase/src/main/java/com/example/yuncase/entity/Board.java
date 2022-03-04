package com.example.yuncase.entity;

import com.example.yuncase.constant.BoardStatus;
import com.example.yuncase.constant.Role;
import com.example.yuncase.dto.BoardFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Getter
@Setter
@ToString
public class Board extends BaseEntity {

    @Id
    @Column(name = "borad_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 50)
    private String boardNm;
    @Column(nullable = false)
    private String boradDetail;
    @Enumerated(EnumType.STRING)
    private BoardStatus boardStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public static Board createBoard(BoardFormDto boardFormDto, Member member) {
        Board board = new Board();
        board.setMember(member);
        board.setBoardNm(boardFormDto.getBoardNm());
        board.setBoradDetail(boardFormDto.getBoardDetail());
        board.setBoardStatus(member.getRole() == Role.ADMIN ? BoardStatus.ADMIN : BoardStatus.GENERAL);

        return board;
    }
}
