package com.qu.exceptions;

import org.jboss.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.json.Json.createArrayBuilder;
import static javax.json.Json.createObjectBuilder;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<RuntimeBusinessException> {
    static final Logger logger = Logger.getLogger(BusinessExceptionMapper.class);

    @Override
    public Response toResponse(RuntimeBusinessException exception) {
        logger.error(exception.getMessage() , exception);
        var exceptionBody =
                createObjectBuilder()
                    .add("error_code", exception.errorCode.name())
                        .add("message", exception.getMessage())
                        .add("additional_data", createArrayBuilder(exception.msgParams))
                    .build();
        return Response
                .status(exception.status.code())
                .entity(exceptionBody)
                .build();
    }
}
