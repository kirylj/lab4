package com.epam.tc.main;

import com.epam.tc.controller.Controller;
import com.epam.tc.view.View;

public class Main {

	public static void main(String[] args)
    {
		View view = new View();
		view.setController(new Controller());
		view.createCallCenter(4);
		for (int i = 0; i < 21; i++)
        {
			view.addClient(i);
		}
	}

}
