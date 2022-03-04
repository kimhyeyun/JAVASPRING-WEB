package com.example.yuncase.repository;

import com.example.yuncase.dto.ItemSearchDto;
import com.example.yuncase.entity.Board;
import com.example.yuncase.entity.QBoard;
import com.example.yuncase.entity.QItem;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class BoardRepositoryCustomImpl implements BoardRepositoryCustom{
    private JPAQueryFactory queryFactory;

    public BoardRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    private BooleanExpression reqDtsAfter(String searchDateType) {
        LocalDateTime dateTime = LocalDateTime.now();

        if(StringUtils.equals("all", searchDateType) || searchDateType == null) return null;
        else if(StringUtils.equals("1d", searchDateType)) dateTime = dateTime.minusDays(1);
        else if(StringUtils.equals("1w",searchDateType)) dateTime = dateTime.minusWeeks(1);
        else if(StringUtils.equals("1m", searchDateType)) dateTime = dateTime.minusMonths(1);
        else if(StringUtils.equals("6m", searchDateType)) dateTime = dateTime.minusMonths(6);

        return QBoard.board.regtime.after(dateTime);
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery) {
        if (StringUtils.equals("itemNm", searchBy)) {
            return QBoard.board.boardNm.like("%" + searchQuery + "%");
        }
        else if(StringUtils.equals("createdBy",searchBy))
            return QBoard.board.createdBy.like("%" + searchQuery + "%");

        return null;
    }
    @Override
    public Page<Board> getBoardPage(ItemSearchDto itemSearchDto, Pageable pageable) {
        QueryResults<Board> results = queryFactory
                .selectFrom(QBoard.board)
                .where(reqDtsAfter(itemSearchDto.getSearchDateType()),
                        searchByLike(itemSearchDto.getSearchBy(), itemSearchDto.getSearchQuery()))
                .orderBy(QBoard.board.boardStatus.asc(), QBoard.board.id.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<Board> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
