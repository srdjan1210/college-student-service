package utils;

import java.awt.Toolkit;

public class Constants {
	public static enum MarksValue {
		SEST(6), SEDAM(7), OSAM(8), DEVET(9), DESET(10);

		private int value;

		MarksValue(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	};

	public enum Semester {
		ZIMSKI("ZIMSKI"), LETNJI("LETNJI");

		private String value;

		Semester(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	};

	public enum Status {
		BUDZET("BUDZET"), SAMOFINANSIRANJE("SAMOFINANSIRANJE");

		private String value;

		Status(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	};

	public static int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static int ICON_BUTTON_HEIGHT = 20;
	public static int ICON_BUTTON_WIDTH = 20;
}
