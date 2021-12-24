package main;

import java.sql.SQLException;
import ui_handler.MainUIHandler;

public class ApplicationSkiSkokovi {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "WARN");
		MainUIHandler mainUIHandler = new MainUIHandler();
		mainUIHandler.handleMainMenu();
	}

}
