package com.inditex.rrhh.icmclcwb.api.meta4.exception;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;

public class Meta4Exception extends IcmclcwbException {

    private static final long serialVersionUID = 2713608924411606103L;

	public Meta4Exception(String message) {
		super(message);
	}
	
	public Meta4Exception(String message, Throwable cause) {
        super(message, cause);
    }
    
}
