package com.usagi.Controller.Controller.Gallery;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.Gallery.Gallery_Delete_Action;
import com.usagi.Controller.Action.Gallery.Gallery_Insert_Action;
import com.usagi.Controller.Action.Gallery.Gallery_Insert_Move;
import com.usagi.Controller.Action.Gallery.Gallery_Move;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("gallery")) {
			action = new Gallery_Move();
		}else if(command.equals("galleryInsertMove")) {
			action = new Gallery_Insert_Move();
		}else if(command.equals("gallery_Insert")) {
			action = new Gallery_Insert_Action();
		}else if(command.equals("GalDelete")) {
			action = new Gallery_Delete_Action();
		}
		return action;
	}
}
