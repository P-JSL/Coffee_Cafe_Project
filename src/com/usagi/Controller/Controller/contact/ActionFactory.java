package com.usagi.Controller.Controller.contact;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.contact.ContactInertAction;
import com.usagi.Controller.Action.contact.Contact_Receive_Massage_Action;
import com.usagi.Controller.Action.contact.Contact_Response_Action;
import com.usagi.Controller.Action.contact.Contact_Response__Move_Action;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if(command.equals("contInsert")) {
			action = new ContactInertAction();
		}else if(command.equals("contResponse")) {
			action = new Contact_Response__Move_Action();
		}else if(command.equals("Request")) {
			action = new Contact_Response_Action();
		}else if(command.equals("Receive")) {
			action = new Contact_Receive_Massage_Action();
		}
		return action;
	}
}
