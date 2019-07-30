package com.inditex.rrhh.icmclcwb.api.app.exception;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;

public class IcmclcwbException extends ApplicationException {

    private static final long serialVersionUID = 2713608924411606103L;

	public IcmclcwbException(String message) {
		super(message);
	}
	
	public IcmclcwbException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
