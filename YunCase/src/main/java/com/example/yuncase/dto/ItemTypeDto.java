package com.example.yuncase.dto;

import com.example.yuncase.constant.OrderStatus;
import com.example.yuncase.entity.Item;
import com.example.yuncase.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ItemTypeDto {
    private String type;

    public ItemTypeDto(Item item) {
        this.type = item.getType();
    }

    private List<ItemTypeListDto> itemTypeListDtos = new ArrayList<>();

    public void addItemTypeListDto(ItemTypeListDto itemTypeListDto) {
        itemTypeListDtos.add(itemTypeListDto);
    }

}
