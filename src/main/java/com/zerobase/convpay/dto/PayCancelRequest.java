package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.ConvenienceType;

public class PayCancelRequest {
    //결제 수단


    //편의점 종류
    ConvenienceType convenienceType;

    //결제 취소 금액
    Integer payCancelAmount;

    public PayCancelRequest(ConvenienceType convenienceType, Integer payCancelAmount) {
        this.convenienceType = convenienceType;
        this.payCancelAmount = payCancelAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayCancelAmount() {
        return payCancelAmount;
    }

    public void setPayCancelAmount(Integer payCancelAmount) {
        this.payCancelAmount = payCancelAmount;
    }

    @Override
    public String toString() {
        return "PayCancelRequest{" +
                "convenienceType=" + convenienceType +
                ", payCancelAmount=" + payCancelAmount +
                '}';
    }
}
