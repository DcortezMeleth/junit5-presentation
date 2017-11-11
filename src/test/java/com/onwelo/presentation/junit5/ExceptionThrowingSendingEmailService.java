package com.onwelo.presentation.junit5;

public class ExceptionThrowingSendingEmailService implements SendingEmailService {

    @Override
    public void sandEmailToSubscribedCustomers() throws NewsletterSendingException {
        throw new NewsletterSendingException();
    }
}
