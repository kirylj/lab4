package com.epam.tc.view;

import com.epam.tc.bean.Request;

/**
 * Created by ʳ��� on 09.05.2015.
 */
public class WaitingForAClientMessage extends  Message
{
    @Override
    public void print(Request request)
    {
        printIndent(request.getOperatorNumber());
        System.out.println("Waiting for a client.");
    }
}
