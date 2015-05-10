package com.epam.tc.controller;

import com.epam.tc.view.MessageType;
import com.epam.tc.bean.Request;
import com.epam.tc.bean.Response;
import com.epam.tc.model.Model;
import com.epam.tc.view.View;

public class Controller {
	
	private Object printLock;
    private View view;
	
	public Controller()
    {
		Model.setController(this);
	}

	public Response execute(Request request) {
		Response response;
		switch (request.getType()) {
			case addClient:
                response = new Response(Model.addClient(request.getClientNumber()));
                break;
			case createCallCenter:
                response = new Response(Model.createCallCenter(request.getNumberOfOperators()));
                break;
			default:
                response = new Response(false);
		}
		return response;
	}

    public void setView(View view)
    {
        this.view = view;
    }

    public void printMessage(Request request)
    {
        view.printMessage(request);
    }
}
