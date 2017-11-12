package com.onwelo.presentation.junit5;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SendingEmailServiceImpl implements SendingEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendingEmailServiceImpl.class);

    @Override
    public void sandEmailToSubscribedCustomers() throws NewsletterSendingException {
        LOGGER.debug("REAL SERVICE!");
    }
}
