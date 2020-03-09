package com.inditex.rrhh.icmclcwb.api.app.exception;

public class IcmclcwbException extends RuntimeException/*TODO [COMUN] ApplicationException*/ {

    private static final long serialVersionUID = 2713608924411606103L;

	public IcmclcwbException(String message) {
		super(message);
	}
	
	public IcmclcwbException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
