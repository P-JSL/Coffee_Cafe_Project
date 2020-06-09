package com.usagi.Controller.Controller.news;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.news.NewsDeleteAction;
import com.usagi.Controller.Action.news.NewsInsertAction;
import com.usagi.Controller.Action.news.NewsModifyAction;
import com.usagi.Controller.Action.news.NewsModifyMoveAction;
import com.usagi.Controller.Action.news.NewsReplyAction;
import com.usagi.Controller.Action.news.NewsViewAction;
import com.usagi.Controller.Action.news.NewsWriteAction;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if(command.equals("newswrite")) 
		{
			action = new NewsWriteAction();
		}
		else if(command.equals("newsInsert")) 
		{
			action = new NewsInsertAction();
		}
		else if(command.equals("newsview")) 
		{
			action = new NewsViewAction();
		}
		else if(command.equals("newsreply"))
		{
			action = new NewsReplyAction();
		}
		else if(command.equals("newsModifyMove"))
		{
			action = new NewsModifyMoveAction();
		}
		else if(command.equals("newsDelete"))
		{
			action = new NewsDeleteAction();
		}
		else if(command.equals("newsModify"))
		{
			action = new NewsModifyAction();
		}
		return action;
	}
	

}
