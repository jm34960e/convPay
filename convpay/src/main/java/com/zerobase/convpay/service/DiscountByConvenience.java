package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;

public class DiscountByConvenience implements DiscountInterface {
    @Override
    public Integer getDiscountenAmount(PayRequest payRequest) {
        switch( payRequest.getConvenienceType() ){ //편의점 별로 할인율 적용
            case G25 -> {

                return payRequest.getPayAmount() * 8 / 10;
            }
            case GU -> {
                return  payRequest.getPayAmount() * 9 / 10;
            }
            case SEVEN -> {
                return payRequest.getPayAmount();
            }
        }

        return payRequest.getPayAmount();
    }
}
