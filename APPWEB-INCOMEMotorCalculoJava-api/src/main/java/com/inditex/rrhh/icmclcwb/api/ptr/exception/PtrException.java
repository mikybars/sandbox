package com.inditex.rrhh.icmclcwb.api.ptr.exception;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;

public class PtrException extends IcmclcwbException {

    private static final long serialVersionUID = 827035738919100848L;

    public PtrException(String message) {
        super(message);
    }

    public PtrException(String message, Throwable cause) {
        super(message, cause);
    }

}
