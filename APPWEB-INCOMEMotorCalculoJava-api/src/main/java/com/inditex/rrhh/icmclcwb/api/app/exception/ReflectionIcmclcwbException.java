package com.inditex.rrhh.icmclcwb.api.app.exception;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;

public class ReflectionIcmclcwbException extends ApplicationException {

    private static final long serialVersionUID = 2713608924411606103L;

	public ReflectionIcmclcwbException(String message) {
		super(message);
	}
	
	public ReflectionIcmclcwbException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
