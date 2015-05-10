package com.epam.tc.view;

import com.epam.tc.bean.Request;
import com.epam.tc.entity.Client;

/**
 * Created by Кірыл on 09.05.2015.
 */
public abstract class Message
{
    public abstract void print(Request request);

    protected void printIndent(int operatorNumber)
    {
        for (int i = 0; i < operatorNumber + 1; i++)
        {
            System.out.print("                              ");
        }
    }
}
