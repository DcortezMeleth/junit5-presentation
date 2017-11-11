package com.onwelo.presentation.junit5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
class AdditionalTestConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    @Primary
    @Profile("exceptions")
    SendingEmailService sendingEmailService() {
        return new ExceptionThrowingSendingEmailService();
    }
}
