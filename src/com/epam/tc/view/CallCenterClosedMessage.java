package com.epam.tc.view;

import com.epam.tc.bean.Request;

/**
 * Created by Кірыл on 09.05.2015.
 */
public class CallCenterClosedMessage extends Message
{
    @Override
    public void print(Request request)
    {
        System.out.println("Call center has been closed.");
    }
}
