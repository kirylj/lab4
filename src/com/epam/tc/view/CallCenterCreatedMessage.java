package com.epam.tc.view;

import com.epam.tc.bean.Request;

/**
 * Created by ʳ��� on 09.05.2015.
 */
public class CallCenterCreatedMessage extends Message
{
    @Override
    public void print(Request request)
    {
        System.out.println("Call center has been created.");
    }
}
