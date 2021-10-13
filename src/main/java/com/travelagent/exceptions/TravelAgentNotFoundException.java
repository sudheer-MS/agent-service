package com.travelagent.exceptions;

public class TravelAgentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TravelAgentNotFoundException() {
		super();
	}

	public TravelAgentNotFoundException(String message) {
		super(message);
	}

}
