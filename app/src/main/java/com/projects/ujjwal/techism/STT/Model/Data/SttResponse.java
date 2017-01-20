package com.projects.ujjwal.techism.STT.Model.Data;

/**
 * Created by ujjwal on 21/1/17.
 */
public class SttResponse {
	boolean success;
	String message;

	public SttResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
}
