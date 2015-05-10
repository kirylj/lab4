package com.epam.tc.bean;

import com.epam.tc.entity.Client;
import com.epam.tc.entity.Operator;
import com.epam.tc.view.MessageType;

public class Request {

	private RequestType type;
    private MessageType messageType;
	private int clientNumber;
	private int numberOfOperators;
    private int[] clientNumbers;
    private int operatorNumber;
	
	public void setType(RequestType type)
    {
		this.type = type;
	}
	
	public RequestType getType()
    {
		return type;
	}

    public void setMessageType(MessageType messageType)
    {
        this.messageType = messageType;
    }

    public MessageType getMessageType()
    {
        return messageType;
    }

    public void setClientNumbers(int[] clientNumbers)
    {
        this.clientNumbers = clientNumbers;
    }

    public int[] getClientNumbers()
    {
        return clientNumbers;
    }

    public void setOperatorNumber(int operatorNumber)
    {
        this.operatorNumber = operatorNumber;
    }

    public int getOperatorNumber()
    {
        return operatorNumber;
    }
	
	public void setClientNumber(int clientNumber)
    {
		this.clientNumber = clientNumber;
	}
	
	public int getClientNumber()
    {
		return clientNumber;
	}
	
	public void setNumberOfOperators(int numberOfOperators)
    {
		this.numberOfOperators = numberOfOperators;
	}
	
	public int getNumberOfOperators()
    {
		return numberOfOperators;
	}
}
