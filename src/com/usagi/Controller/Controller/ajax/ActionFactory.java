package com.usagi.Controller.Controller.ajax;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.ajax.BoardHitCountAction;
import com.usagi.Controller.Action.ajax.BoardReplyDeleteAction;
import com.usagi.Controller.Action.ajax.Change_Pw_Action;
import com.usagi.Controller.Action.ajax.Email_Id_Auth_Action;
import com.usagi.Controller.Action.ajax.Email_Pw_Auth_Action;
import com.usagi.Controller.Action.ajax.Notice_Hit_Action;
import com.usagi.Controller.Action.ajax.Notice_reply_delete_Action;
import com.usagi.Controller.Action.ajax.PassWordConfirmAction;
import com.usagi.Controller.Action.ajax.SignUpIdCheckAction;
import com.usagi.Controller.Action.ajax.likeAction;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if (command.equals("ReplyDelete")) {
			action = new BoardReplyDeleteAction();
		}else if(command.equals("count")) {
			action = new BoardHitCountAction();
		}else if(command.equals("MypagePassConfirm")) {
			action = new PassWordConfirmAction();
		}else if(command.equals("Notice_Reply_Delete")) {
			action = new Notice_reply_delete_Action();
		}else if(command.equals("idcheck")) {
			action = new SignUpIdCheckAction();
		}else if(command.equals("email_send")) {
			action = new Email_Id_Auth_Action();
		}else if(command.equals("pw_send")) {
			action = new Email_Pw_Auth_Action();
		}else if(command.equals("pw_update")) {
			action = new Change_Pw_Action();
		}else if(command.equals("Notice_hit")) {
			action = new Notice_Hit_Action();
		}else if(command.equals("like")) {
			action = new likeAction();
		}
		return action;
	}
}
