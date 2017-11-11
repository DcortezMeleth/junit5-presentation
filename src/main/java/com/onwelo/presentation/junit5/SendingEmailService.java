package com.onwelo.presentation.junit5;

public interface SendingEmailService {

    void sandEmailToSubscribedCustomers() throws NewsletterSendingException;
}
