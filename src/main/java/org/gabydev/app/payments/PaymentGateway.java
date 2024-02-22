package org.gabydev.app.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);

}
