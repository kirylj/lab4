package com.epam.tc.model;

import com.epam.tc.bean.Request;
import com.epam.tc.controller.Controller;
import com.epam.tc.entity.CallCenter;
import com.epam.tc.entity.Client;
import com.epam.tc.view.MessageType;

public class Model {

	private static CallCenter callCenter;
    private static Controller controller;
	
	private Model() {}

    public static void setController(Controller controller)
    {
        Model.controller = controller;
    }

    public static void printMessage(MessageType messageType, int operatorNumber, int clientNumber, int[] clientNumbers)
    {
        Request request = new Request();
        request.setMessageType(messageType);
        request.setOperatorNumber(operatorNumber);
        request.setClientNumber(clientNumber);
        request.setClientNumbers(clientNumbers);
        controller.printMessage(request);
    }
	
	public static boolean createCallCenter(int numberOfOperators)
    {
		callCenter = CallCenter.getInstance(numberOfOperators);
		return true;
	}
	
	public static boolean addClient(int number)
    {
		Client client = new Client(number, callCenter);
		client.start();
		return true;
	}
}
