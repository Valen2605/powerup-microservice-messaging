package com.pragma.powerup.messagingmicroservice.adapters.driving.http.handlers.impl;


import com.pragma.powerup.messagingmicroservice.adapters.driving.http.handlers.IMessagingHandler;
import com.pragma.powerup.messagingmicroservice.domain.api.IMessagingServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MessagingHandlerImpl implements IMessagingHandler {

    private final IMessagingServicePort messagingServicePort;
    @Override
    public void sendMessage(String bodyMessage, String number) {
       messagingServicePort.sendMessage(bodyMessage,number);
    }
}
