package com.epam.tc.entity;

import com.epam.tc.bean.Request;
import com.epam.tc.model.Model;
import com.epam.tc.view.MessageType;

import java.util.*;

public class CallCenter
{
	
	private static CallCenter instance = null;
	private Operator[] operators;
	private Queue<Client> clients;
	
	public static CallCenter getInstance(int numberOfOperators)
    {
		if (instance == null)
        {
			instance = new CallCenter(numberOfOperators);
		}
		return instance;
	}
	
	private CallCenter(int numberOfOperators)
    {
		clients = new LinkedList<Client>();
		operators = new Operator[numberOfOperators];
		for (int i = 0; i < operators.length; i++)
        {
			operators[i] = new Operator(clients);
			operators[i].setNumber(i);
			operators[i].start();
		}
	}
	
	public void add(Client client)
    {
		synchronized (clients)
        {
            clients.add(client);
			clients.notify();
            int[] clientNumbers = new int[clients.size()];
            int i = 0;
            for (Client c : clients)
            {
                clientNumbers[i] = c.getNumber();
                i++;
            }
            Model.printMessage(MessageType.showClients, 0, 0, clientNumbers);
		}
	}
	
	public void recall(Client client)
    {
		boolean isRemoved;
		synchronized (clients)
        {
			isRemoved = clients.remove(client);
			if (isRemoved)
            {
				clients.add(client);
                Model.printMessage(MessageType.clientRecalled, 0, client.getNumber(), null);
            }
            int[] clientNumbers = new int[clients.size()];
            int i = 0;
            for (Client c : clients)
            {
                clientNumbers[i] = c.getNumber();
                i++;
            }
            Model.printMessage(MessageType.showClients, 0, 0, clientNumbers);
		}
	}
	
	public void close()
    {
		for (Operator operator : operators)
        {
			operator.finishWork();
		}
	}
}
