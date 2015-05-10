package com.epam.tc.entity;

import java.util.Random;

public class Client extends Thread
{
	
	private CallCenter callCenter;
	private int number;
	private Boolean isServed;
	private Object lock;
    private int waitForAnswer;
	
	public Client(int number, CallCenter callCenter)
    {
		this.number = number;
		isServed = false;
		lock = new Object();
		this.callCenter = callCenter;
        Random random = new Random();
        waitForAnswer = random.nextInt(5) * 50 + 1000;
	}
	
	public void run()
    {
		callCenter.add(this);
		synchronized (lock)
        {
			while (isServed == false)
            {
				try
                {
					lock.wait(waitForAnswer);
				} catch (InterruptedException e)
                {
					e.printStackTrace();
				}
				if (isServed == false)
                {
					recall();
				}
			}
		}
	}
	
	public void recall()
    {
		callCenter.recall(this);
	}
	
	public int getNumber()
    {
		return number;
	}
	
	public void setServed()
    {
		synchronized (lock)
        {
			isServed = true;
			lock.notify();
			return;
		}
	}
	
	public boolean equals(Object obj)
    {
		Client client = (Client) obj;
		return this.number == client.number;
	}
}
