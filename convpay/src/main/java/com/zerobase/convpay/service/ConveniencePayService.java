package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;

public class ConveniencePayService { //편결이
    private final MoneyAdapter moneyAdapter= new MoneyAdapter();
    private final CardAdapter cardAdapter = new CardAdapter();
   //private final PointAdapter pointAdapter = new CardAdapter();
    private final DiscountInterface discountInterface = new DiscountByPayMethod();

    public PayResponse pay(PayRequest payRequest){
        PaymentInterface paymentInterface;

        if(payRequest.getPayMethodType() == PayMethodType.CARD){
            paymentInterface = cardAdapter;
        }else {
            paymentInterface = moneyAdapter;
        }

        //결제 금액 넣기
        Integer discountedAmount = discountInterface.getDiscountenAmount(payRequest);
        PaymentResult payment = paymentInterface.payment(payRequest.getPayAmount());

        //fail fast
        if(payment == PaymentResult.PAYMENT_FAIL){
            return new PayResponse(PayResult.FAIL,0);
        }

        //Success Case
        return new PayResponse(PayResult.SUCCESS,payRequest.getPayAmount());

    }


    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface;

        if(payCancelRequest.getPayMethodType() == PayMethodType.CARD){
            paymentInterface = cardAdapter;
        }else{
            paymentInterface = moneyAdapter;
        }

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        if(cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL){
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL,0);
        }

        //Success Case
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
