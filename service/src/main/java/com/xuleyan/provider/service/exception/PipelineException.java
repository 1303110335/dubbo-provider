/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.service.exception;

/**
 *
 * @author xuleyan
 * @version PipelineException.java, v 0.1 2021-08-21 9:38 下午
 */
public class PipelineException extends RuntimeException {

    public PipelineException(Throwable e) {
        super(e);
    }

    public PipelineException(String message) {
        super(message);
    }

    public PipelineException(String errCode, String errMsg) {
        super(errCode + "\n" + errMsg);
    }

    public PipelineException(String message, Throwable cause) {
        super(message, cause);
    }

}