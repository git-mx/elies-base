
package com.elies.base.common;

import com.elies.base.constant.ResponseMessage;

import java.util.Map;
/**
 * @author 牟雪
 * @since 2018/4/13
 */
public class ExceptionUtil extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String code;

    public ExceptionUtil(String code, String message) {
        this(code, message, null);
    }

    public ExceptionUtil(String code, String message, Throwable t) {
        super(message, t);
        this.code = code;
    }

    public ExceptionUtil(Throwable t) {
        this(ResponseMessage.RETURN_CODE_UNKNOWN_ERROR, t);
    }

    public ExceptionUtil(MessageUtil messageUtil) {
        this(messageUtil.getCode(), messageUtil.getMessage(), null);
    }

    public ExceptionUtil(MessageUtil messageUtil, Throwable t) {
        this(messageUtil.getCode(), messageUtil.getMessage(), t);
    }

    public ExceptionUtil(MessageUtil messageUtil, String paramValue) {
        this(messageUtil.getCode(), messageUtil.getMessage(paramValue), null);
    }

    public ExceptionUtil(MessageUtil messageUtil, Throwable t, String paramValue) {
        this(messageUtil.getCode(), messageUtil.getMessage(paramValue), t);
    }

    public ExceptionUtil(MessageUtil messageUtil, Map paramValues) {
        this(messageUtil.getCode(), messageUtil.getMessage(paramValues), null);
    }

    public ExceptionUtil(MessageUtil messageUtil, Throwable t, Map paramValues) {
        this(messageUtil.getCode(), messageUtil.getMessage(paramValues), t);
    }

    public String getCode() {
        return this.code;
    }
}
