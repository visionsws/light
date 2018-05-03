package com.vicente.light.exception;

/**
 * @author shiweisen
 * @since 2018-01-24
 */
public class LightException extends RuntimeException {

    private String code;

    public LightException(String code,String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
