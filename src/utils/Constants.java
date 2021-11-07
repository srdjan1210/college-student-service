package utils;

import java.awt.Toolkit;

public class Constants {
	public static enum BrOcena {
		SEST, SEDAM, OSAM, DEVET, DESET
	};

	public static enum Semestar {
		ZIMSKI, LETNJI
	};

	public static enum Status {
		BUDZET, SAMOFINANSIRANJE
	};

	public static int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static int ICON_BUTTON_HEIGHT = 20;
	public static int ICON_BUTTON_WIDTH = 20;
}
