package com.example.websocketpractice;

public class CustomException extends RuntimeException {

	public CustomException() {
	}

	public CustomException( String message ) {
		super( message );
	}

	public static class CustomFirstException extends CustomException {

		public CustomFirstException() {
		}

		public CustomFirstException( String message ) {
			super( message );
		}
	}

	public static class CustomSecondException extends CustomException {

		public CustomSecondException() {
		}

		public CustomSecondException( String message ) {
			super( message );
		}
	}
}
