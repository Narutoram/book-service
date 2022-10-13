package com.digitalbooks.exception;

public class DigitalbooksNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DigitalbooksNotFoundException() {
	}

	public DigitalbooksNotFoundException(String message) {
		super(message);

	}

	public DigitalbooksNotFoundException(Throwable cause) {
		super(cause);
	}

	public DigitalbooksNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public DigitalbooksNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
