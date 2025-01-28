package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;

public class DiscountByPayMethod implements DiscountInterface {

    @Override
    public Integer getDiscountenAmount(PayRequest payRequest) {
        switch( payRequest.getPayMethodType()){
            case MONEY -> {
                return payRequest.getPayAmount() * 7 / 10;
            }
            case CARD -> {
                return payRequest.getPayAmount();
            }
        }
        return payRequest.getPayAmount();
    }
}
