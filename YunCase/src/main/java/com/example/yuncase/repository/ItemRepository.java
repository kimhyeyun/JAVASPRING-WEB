package com.example.yuncase.repository;

import com.example.yuncase.entity.Item;
import com.example.yuncase.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item>, ItemRepositoryCustom {
    List<Item> findByItemNm(String itemNm);

    List<Item> findByType(String type);

    @Query("select i from Item i " + "where i.type = :type " + "order by i.id asc ")
    List<Item> findItems(@Param("type") String type);

    @Query("select count(i) from Item i " + "where i.type = :type")
    Long countItems(@Param("type") String type);

}
