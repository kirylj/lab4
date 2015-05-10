package com.epam.tc.view;

import com.epam.tc.bean.Request;

/**
 * Created by Кірыл on 09.05.2015.
 */
public class WorkingWithAClientMessage extends Message
{
    @Override
    public void print(Request request)
    {
        printIndent(request.getOperatorNumber());
        System.out.println("Working with a client " + request.getClientNumber() + ".");
    }
}
