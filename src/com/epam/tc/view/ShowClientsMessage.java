package com.epam.tc.view;

import com.epam.tc.bean.Request;
import com.epam.tc.entity.Client;

/**
 * Created by Кірыл on 09.05.2015.
 */
public class ShowClientsMessage extends Message
{
    @Override
    public void print(Request request)
    {
        for (int i : request.getClientNumbers())
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
