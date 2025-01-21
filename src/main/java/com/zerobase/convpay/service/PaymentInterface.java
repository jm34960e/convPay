package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CancelPaymentResult;
import com.zerobase.convpay.type.PaymentResult;

public class PaymentInterface {
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelpayment(Integer cancelAmount);

}
