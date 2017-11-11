package com.onwelo.presentation.junit5;

import org.springframework.stereotype.Service;

@Service
public class SendingEmailServiceImpl implements SendingEmailService {

    @Override
    public void sandEmailToSubscribedCustomers() throws NewsletterSendingException {
        // sending email
    }
}
