package com.usagi.Controller.Controller.bean;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.bean.BeanInserAction;
import com.usagi.Controller.Action.bean.BeanModifyAction;
import com.usagi.Controller.Action.bean.BeanModifyMoveAction;
import com.usagi.Controller.Action.bean.BeanWriteAction;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if (command.equals("beanWrite")) {
			action = new BeanWriteAction();
		} else if (command.equals("beanInsert")) {
			action = new BeanInserAction();
		}else if(command.equals("beanModifyMove")) {
			action = new BeanModifyMoveAction();
		}else if(command.equals("beanModify")) {
			action = new BeanModifyAction();
		}
		return action;
	}
}
