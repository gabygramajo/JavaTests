package org.gabydev.app.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {
    // campos de la clase
    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setup() { // codigo que se repite en ambos tests

        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }


    @Test
    public void payment_is_correct() {

        // Preparación de los objetos
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));


        //Llamamos al métodos que estamos probando.
        boolean result = paymentProcessor.makePayment(1000);

        //Comprobamos los resultados.
        assertTrue(result);
    }

    @Test
    public void payment_is_incorrect() {

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));


        boolean result = paymentProcessor.makePayment(1000);

        assertFalse(result);
    }
}