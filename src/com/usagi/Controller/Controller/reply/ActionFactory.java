package com.usagi.Controller.Controller.reply;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.reply.My_Reply_Delete_Action;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if(command.equals("MyReplyDelete")) {
			action = new My_Reply_Delete_Action();
		}
		return action;
	}
}
