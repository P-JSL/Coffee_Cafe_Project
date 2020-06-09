package com.usagi.Controller.Controller.HMC;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.HMC.HmcDeleteAction;
import com.usagi.Controller.Action.HMC.HmcInsertAction;
import com.usagi.Controller.Action.HMC.HmcModifyMove;
import com.usagi.Controller.Action.HMC.HmcUpdateAction;
import com.usagi.Controller.Action.HMC.HmcViewAction;
import com.usagi.Controller.Action.HMC.HmcWriteMoveAction;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("HmcView")) {
			action = new HmcViewAction();
		}else if(command.equals("HmcWriteMove")) {
			action = new HmcWriteMoveAction();
		}else if(command.equals("HmcInsert")) {
			action = new HmcInsertAction();
		}else if(command.equals("HmcDelete")) {
			action = new HmcDeleteAction();
		}else if(command.equals("HmcModify")) {
			action = new HmcModifyMove();
		}else if(command.equals("HmcUpdate")) {
			action = new HmcUpdateAction();
		}
		return action;
	}
	

}
