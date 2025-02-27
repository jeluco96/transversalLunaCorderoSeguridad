package acceso.gestor.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Response {
	public static final int NO_ERROR = 0;
	public static final int NOT_FOUND = 101;
	public static final String NO_MESSAGE = "";

	private Error error;

	@Data
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	static class Error {
		private long errorCode;
		private String message;
	}



}
