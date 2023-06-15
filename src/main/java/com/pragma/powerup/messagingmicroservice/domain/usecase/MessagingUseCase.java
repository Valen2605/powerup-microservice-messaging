package com.pragma.powerup.messagingmicroservice.domain.usecase;

import com.pragma.powerup.messagingmicroservice.domain.api.IMessagingServicePort;
import com.pragma.powerup.messagingmicroservice.domain.spi.IMessagingPersistencePort;


public class MessagingUseCase implements IMessagingServicePort {


    IMessagingPersistencePort messagingPersistencePort;

    public MessagingUseCase(IMessagingPersistencePort messagingPersistencePort) {
        this.messagingPersistencePort = messagingPersistencePort;
    }

    @Override
    public void sendMessage(String bodyMessage) {
        messagingPersistencePort.sendMessage(bodyMessage);
    }
}
