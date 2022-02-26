package com.example.yuncase.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemSearchDto {
    private String searchDateType;
    private String searchBy;
    private String searchQuery = "";
}
