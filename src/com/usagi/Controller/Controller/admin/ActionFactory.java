package com.usagi.Controller.Controller.admin;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.admin.AdminPageAction;
import com.usagi.Controller.Action.admin.Admin_Notice_Delete_Action;
import com.usagi.Controller.Action.admin.Admin_Notice_Modify_Move;
import com.usagi.Controller.Action.admin.Admin_User_Unregister_Action;
import com.usagi.Controller.Action.admin.LoginMoveAction;
import com.usagi.Controller.Action.admin.loginAction;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if(command.equals("login")) {
			action = new loginAction();
		}else if(command.equals("loginmove")) {
			action = new LoginMoveAction();
		}else if(command.equals("adminPage")) {
			action = new AdminPageAction();
		}else if(command.equals("admin_notice_modify_move")) {
			action = new Admin_Notice_Modify_Move();
		}else if(command.equals("admin_notice_delete")) {
			action = new Admin_Notice_Delete_Action();
		}else if(command.equals("Admin_User_Unregister")) {
			action = new Admin_User_Unregister_Action();
		}
		return action;
	}
}
