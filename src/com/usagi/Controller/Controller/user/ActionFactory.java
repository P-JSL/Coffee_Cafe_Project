package com.usagi.Controller.Controller.user;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.user.LogoutAction;
import com.usagi.Controller.Action.user.MyPageAction;
import com.usagi.Controller.Action.user.MyPwCheckAction;
import com.usagi.Controller.Action.user.MypageModifyPwCheckAction;
import com.usagi.Controller.Action.user.UserModifyAction;
import com.usagi.Controller.Action.user.UserSignUpAction;
import com.usagi.Controller.Action.user.UserloginAction;
import com.usagi.Controller.Action.user.UserloginMoveAction;
import com.usagi.Controller.Action.user.contactAction;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if (command.equals("signup")) {
			action = new UserSignUpAction();
		} else if (command.equals("loginmove")) {
			action = new UserloginMoveAction();
		} else if (command.equals("userlogin")) {
			action = new UserloginAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("contact")) {
			action = new contactAction();
		} else if (command.equals("modifyPw")) {
			action = new MypageModifyPwCheckAction();
		} else if (command.equals("usermodify")) {
			action = new UserModifyAction();
		} else if (command.equals("MyPwCheck")) {
			action = new MyPwCheckAction();
		} else if (command.equals("mypage")) {
			action = new MyPageAction();
		} 
		return action;
	}
}
