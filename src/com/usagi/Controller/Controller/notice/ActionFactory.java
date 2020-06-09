package com.usagi.Controller.Controller.notice;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.notice.NoticeInsertAction;
import com.usagi.Controller.Action.notice.NoticeReplyAction;
import com.usagi.Controller.Action.notice.NoticeViewAction;
import com.usagi.Controller.Action.notice.NoticeWriteAction;
import com.usagi.Controller.Action.notice.Notice_Modify_Admin_Action;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("noticeView")) {
			action = new NoticeViewAction();
		}else if(command.equals("noticeWrite")) {
			action = new NoticeWriteAction();
		}else if(command.equals("noticeInsert")) {
			action = new NoticeInsertAction();
		}else if(command.equals("noticeView")) {
			action = new NoticeViewAction();
		}else if(command.equals("noticeReply")) {
			action = new NoticeReplyAction();
		}else if(command.equals("noticeModify")) {
			action = new Notice_Modify_Admin_Action();
		}
		
		return action;
	}
}
