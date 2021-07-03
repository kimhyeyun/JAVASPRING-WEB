package com.company.design.stategy;

public class Appendstrategy implements EncodingStrategy{
    @Override
    public String encode(String text) {
        return "ABCD"+text;
    }
}
