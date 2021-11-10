package utils;

import utils.Constants.Status;

public class EnumConversion {

	public static Status stringToStatus(String status) {
		return status.equals("B")? Status.BUDZET : Status.SAMOFINANSIRANJE;
	}
}
