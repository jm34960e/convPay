package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;

public interface DiscountInterface {
    Integer getDiscountenAmount(PayRequest payRequest);
}
