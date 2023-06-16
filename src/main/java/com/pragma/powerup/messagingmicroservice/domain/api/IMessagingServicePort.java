package com.pragma.powerup.messagingmicroservice.domain.api;


public interface IMessagingServicePort {
    void sendMessage(String bodyMessage, String number);
}
