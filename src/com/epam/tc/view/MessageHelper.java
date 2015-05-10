package com.epam.tc.view;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Кірыл on 09.05.2015.
 */
public class MessageHelper
{
    private Map<MessageType, Message> messages;

    public MessageHelper()
    {
        messages = new HashMap<>();
        messages.put(MessageType.callCenterCreated, new CallCenterCreatedMessage());
        messages.put(MessageType.clientIsCalling, new ClientIsCallingMessage());
        messages.put(MessageType.waitingForAClient, new WaitingForAClientMessage());
        messages.put(MessageType.clientRecalled, new ClientRecalledMessage());
        messages.put(MessageType.noMoreClients, new NoMoreClientsMessage());
        messages.put(MessageType.workingWithAClient, new WorkingWithAClientMessage());
        messages.put(MessageType.clientServed, new ClientServedMessage());
        messages.put(MessageType.callCenterClosed, new CallCenterClosedMessage());
        messages.put(MessageType.showClients, new ShowClientsMessage());
    }

    public Message getMessage(MessageType messageType)
    {
        return messages.get(messageType);
    }
}
