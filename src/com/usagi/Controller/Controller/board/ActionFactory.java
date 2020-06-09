package com.usagi.Controller.Controller.board;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.board.BoardInsertAction;
import com.usagi.Controller.Action.board.BoardViewAction;
import com.usagi.Controller.Action.board.Board_Delete_Action;
import com.usagi.Controller.Action.board.Board_Modify_Action;
import com.usagi.Controller.Action.board.Board_Modify_Move_Action;
import com.usagi.Controller.Action.board.Board_unlock_Action;
import com.usagi.Controller.Action.board.ReplyAction;
import com.usagi.Controller.Action.board.boardWrite;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if (command.equals("boardWrite")) {
			action = new boardWrite();
		} else if (command.equals("boardView")) {
			action = new BoardViewAction();
		} else if (command.equals("boardInsert")) {
			action = new BoardInsertAction();
		} else if (command.equals("reply")) {
			action = new ReplyAction();
		} else if (command.equals("board_unlock_view")) {
			action = new Board_unlock_Action();
		}else if(command.equals("boardmodifymove")) {
			action = new Board_Modify_Move_Action();
		}else if(command.equals("boardModify")) {
			action = new Board_Modify_Action();
		}else if(command.equals("boarddelete")) {
			action = new Board_Delete_Action();
		}
		return action;
	}

}
