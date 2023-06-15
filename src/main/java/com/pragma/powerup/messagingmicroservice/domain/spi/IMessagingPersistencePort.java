package com.pragma.powerup.messagingmicroservice.domain.spi;

public interface IMessagingPersistencePort {

    void sendMessage(String bodyMessage);
}
