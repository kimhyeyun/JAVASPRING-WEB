package com.example.yuncase.dto;

import com.example.yuncase.entity.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemTypeListDto {
    private Long itemId;
    private String itemNm;
    private int orderPrice;
    private String imgUrl;

    public ItemTypeListDto(Item item, String imgUrl) {
        this.itemId = item.getId();
        this.itemNm = item.getItemNm();
        this.orderPrice = item.getPrice();
        this.imgUrl = imgUrl;
    }
}
