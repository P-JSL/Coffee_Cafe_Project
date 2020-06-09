package com.usagi.Controller.Controller.forgot;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.forgot.Email_id_Auth_Move_Action;
import com.usagi.Controller.Action.forgot.ForgotIdAction;
import com.usagi.Controller.Action.forgot.ForgotPwAction;
import com.usagi.Controller.Action.forgot.ForgotSearchIdAction;
import com.usagi.Controller.Action.forgot.Pw_Search_Move_Action;
import com.usagi.Controller.Action.forgot.Your_Id_View_Action;
import com.usagi.Controller.Action.forgot.Your_Pw_View_Action;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if(command.equals("forgotid")) {
			action = new ForgotIdAction();
		}else if(command.equals("forgotpw")) {
			action = new ForgotPwAction();
		}else if(command.equals("Search_id")) {
			action = new ForgotSearchIdAction();
		}else if(command.equals("email_Auth_id")) {
			action = new Email_id_Auth_Move_Action();
		}else if(command.equals("your_id")) {
			action = new Your_Id_View_Action();
		}else if(command.equals("pw_search")) {
			action = new Pw_Search_Move_Action();
		}else if(command.equals("your_pw")) {
			action = new Your_Pw_View_Action();
		}
		return action;
	}
}
