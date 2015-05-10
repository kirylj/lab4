package com.epam.tc.entity;

import com.epam.tc.model.Model;
import com.epam.tc.view.MessageType;

import java.util.Queue;
import java.util.Random;

public class Operator extends Thread
{
	
	private boolean work = true;
	private int number;
	private Queue<Client> clients;
    private int waitForClientTime;
    private int workWithClientTime;
	
	public Operator(Queue<Client> clients)
    {
		this.clients = clients;
        Random random = new Random();
        waitForClientTime = random.nextInt(6) * 500 + 3000;
        workWithClientTime = random.nextInt(3) * 100 + 500;
	}
	
	public void setNumber(int number)
    {
		this.number = number;
	}

    public int getNumber()
    {
        return this.number;
    }
	
	public void run()
    {
		Client client;
		while (work)
        {
			synchronized (clients)
            {
				client = clients.poll();
				if (client == null)
                {
                    Model.printMessage(MessageType.waitingForAClient, getNumber(), 0, null);
					try
                    {
						clients.wait(waitForClientTime);
					} catch (InterruptedException e)
                    {
						e.printStackTrace();
					}
					client = clients.poll();
				}
			}
			if (client != null)
            {
                Model.printMessage(MessageType.workingWithAClient, getNumber(), client.getNumber(), null);
				try
                {
					Thread.sleep(workWithClientTime);
				} catch (InterruptedException e)
                {
					e.printStackTrace();
				}
				client.setServed();
                Model.printMessage(MessageType.clientServed, getNumber(), client.getNumber(), null);
			} else
            {
                Model.printMessage(MessageType.noMoreClients, getNumber(), 0, null);
				finishWork();
			}
		}
        Model.printMessage(MessageType.callCenterClosed, getNumber(), 0, null);
    }
	
	public void finishWork()
    {
		work = false;
	}
}
