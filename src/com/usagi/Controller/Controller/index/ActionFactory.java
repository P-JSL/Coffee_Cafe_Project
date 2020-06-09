package com.usagi.Controller.Controller.index;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.Index.NonUserMailAuthAction;
import com.usagi.Controller.Action.Index.SignUpMoveAction;
import com.usagi.Controller.Action.Index.indexAction;
import com.usagi.Controller.Action.Index.indexAuthAction;
import com.usagi.Controller.Action.Index.indexSelectAction;
import com.usagi.Controller.Action.Index.mainAction;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if(command.equals("index")) {
			action = new indexAction();
		}else if(command.equals("indexSelect")) {
			action = new indexSelectAction();
		}else if(command.equals("indexAuth")) {
			action = new indexAuthAction();
		}else if(command.equals("indexAuthOk")) {
			action = new NonUserMailAuthAction();
		}else if(command.equals("main")) {
			action = new mainAction();
		}//인덱스 --> 비회원 --> 로그인 , 인덱스 --> 회원/관리자 --> 선별
		else if(command.equals("signupmove")) {
			action = new SignUpMoveAction();
		}
		return action;
	}
	

}
