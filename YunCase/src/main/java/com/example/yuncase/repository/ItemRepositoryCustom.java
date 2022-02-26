package com.example.yuncase.repository;

import com.example.yuncase.dto.ItemSearchDto;
import com.example.yuncase.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {
    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
