package com.epam.tc.view;

import com.epam.tc.bean.Request;
import com.epam.tc.bean.RequestType;
import com.epam.tc.bean.Response;
import com.epam.tc.controller.Controller;

public class View
{

	private Controller controller;
    private MessageHelper messageHelper;
	
	public View()
    {
        messageHelper = new MessageHelper();
	}
	
	public void setController(Controller controller)
    {
		this.controller = controller;
        this.controller.setView(this);
	}
	
	public void addClient(int clientNumber)
    {
		Request request = new Request();
        request.setType(RequestType.addClient);
		request.setClientNumber(clientNumber);
		Response response = controller.execute(request);
        if (response.isSucceed())
        {
            request.setMessageType(MessageType.clientIsCalling);
            printMessage(request);
        }
	}
	
	public void createCallCenter(int numberOfOperators)
    {
		Request request = new Request();
        request.setType(RequestType.createCallCenter);
		request.setNumberOfOperators(numberOfOperators);
		Response response = controller.execute(request);
		if (response.isSucceed())
        {
            request.setMessageType(MessageType.callCenterCreated);
			printMessage(request);
		}
	}

    public synchronized void printMessage(Request request)
    {
        Message message = messageHelper.getMessage(request.getMessageType());
        message.print(request);
    }

}
