package com.example.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Req<T> {

    private Header header;
    private T resBody;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Header{
        private String responseCode;
    }
}
