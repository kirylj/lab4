package com.epam.tc.view;

import com.epam.tc.bean.Request;

/**
 * Created by Кірыл on 09.05.2015.
 */
public class ClientServedMessage extends Message
{
    @Override
    public void print(Request request)
    {
        printIndent(request.getOperatorNumber());
        System.out.println("Client " + request.getClientNumber() + " has been served.");
    }
}
