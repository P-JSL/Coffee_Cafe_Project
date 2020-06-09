package com.usagi.Controller.Controller.file;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Action.file.Download;
import com.usagi.Controller.Action.file.File_Upload;
import com.usagi.Controller.Action.file.Upload;
import com.usagi.Controller.Action.file.file_download;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("/upload.file")) {
			action = new Upload();
		}else if(command.equals("/download.file")) {
			action = new Download();
		}else if(command.equals("/upload_file.file")) {
			action = new File_Upload();
		}else if(command.equals("/dl.file")) {
			action = new file_download();
		}
		return action;
	}
}
