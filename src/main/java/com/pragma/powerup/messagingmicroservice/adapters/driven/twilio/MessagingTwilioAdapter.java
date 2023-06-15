package com.pragma.powerup.messagingmicroservice.adapters.driven.twilio;


import com.pragma.powerup.messagingmicroservice.domain.spi.IMessagingPersistencePort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class MessagingTwilioAdapter implements IMessagingPersistencePort {

    public static final String ACCOUNT_SID = "ACe353e46e5dfd0b20c98d02d2fefe9e8f";
    public static final String AUTH_TOKEN = "33920f3beb3cd839dd193fef3637f8d9";



   @Override
   public void sendMessage(String bodyMessage){
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(
            new com.twilio.type.PhoneNumber("+573127982069"),
            new com.twilio.type.PhoneNumber("+13262223055"),
            bodyMessage)
            .create();
   }
}
