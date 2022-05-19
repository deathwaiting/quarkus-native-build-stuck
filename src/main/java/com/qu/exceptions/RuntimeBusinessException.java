package com.qu.exceptions;

import io.netty.handler.codec.http.HttpResponseStatus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RuntimeBusinessException extends RuntimeException {

    public Errors errorCode;
    public HttpResponseStatus status;
    public List<?> msgParams;

    public RuntimeBusinessException(HttpResponseStatus status, Errors errorCode, Object ... params){
        super(createMessage(errorCode, params));
        this.status = status;
        this.errorCode = errorCode;
        this.msgParams = Optional.ofNullable(params).map(Arrays::asList).orElseGet(Collections::emptyList);
    }


    private static String createMessage(Errors errorCode, Object[] params) {
        return String.format(errorCode.getMessage(), params);
    }
}
