package com.pragma.powerup.messagingmicroservice.configuration;



import com.pragma.powerup.messagingmicroservice.adapters.driven.twilio.MessagingTwilioAdapter;
import com.pragma.powerup.messagingmicroservice.domain.api.IMessagingServicePort;
import com.pragma.powerup.messagingmicroservice.domain.spi.IMessagingPersistencePort;
import com.pragma.powerup.messagingmicroservice.domain.usecase.MessagingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    @Bean
    public IMessagingPersistencePort messagingPersistencePort() {
        return new MessagingTwilioAdapter();
    }

    @Bean
    public IMessagingServicePort messagingServicePort() {
        return new MessagingUseCase(messagingPersistencePort());
    }

}
