package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByConvenienceTest {
    @Test
    void discountTest(){
        //given
        PayRequest payRequesG25 =
                new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);
        PayRequest payRequesGU =
                new PayRequest(PayMethodType.MONEY, ConvenienceType.GU, 1000);
        PayRequest payRequesSeven =
                new PayRequest(PayMethodType.MONEY, ConvenienceType.SEVEN, 1000);

        //when
        Integer discountedAmountG25 = discountByConvenience.getDiscountedAmount(payRequesG25);
        Integer discountedAmountGU = discountByConvenience.getDiscountedAmount(payRequesG25);
        Integer discountedAmountSeven = discountByConvenience.getDiscountedAmount(payRequesG25);

        //then
        assertEquals(800, discountedAmountG25);
        assertEquals(900, discountedAmountGU);
        assertEquals(1000, discountedAmountSEVEN);


    }
}