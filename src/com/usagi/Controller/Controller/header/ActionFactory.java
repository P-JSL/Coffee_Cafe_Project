package com.usagi.Controller.Controller.header;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.header.BeanAction;
import com.usagi.Controller.Action.header.BoardAction;
import com.usagi.Controller.Action.header.CultureAction;
import com.usagi.Controller.Action.header.HistoryAction;
import com.usagi.Controller.Action.header.HmcAction;
import com.usagi.Controller.Action.header.IntroAction;
import com.usagi.Controller.Action.header.NewsAction;
import com.usagi.Controller.Action.header.NoticeAction;
import com.usagi.Controller.Action.header.QnaAction;
import com.usagi.Controller.Action.header.SignEmailAuthOkAction;
import com.usagi.Controller.Action.header.authMoveAction;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if (command.equals("Intro")) {
			action = new IntroAction();
		} else if (command.equals("News")) {
			action = new NewsAction();
		} else if (command.equals("Bean")) {
			action = new BeanAction();
		} else if (command.equals("HMC")) {
			action = new HmcAction();
		} else if (command.equals("History")) {
			action = new HistoryAction();
		} else if (command.equals("Culture")) {
			action = new CultureAction();
		} else if (command.equals("Board")) {
			action = new BoardAction();
		} else if (command.equals("Notice")) {
			action = new NoticeAction();
		} else if (command.equals("QnA")) {
			action = new QnaAction();
		} else if (command.equals("authMove")) {
			action = new authMoveAction();
		} else if (command.equals("authOk")) {
			action = new SignEmailAuthOkAction();
		}
		return action;
	}
}
