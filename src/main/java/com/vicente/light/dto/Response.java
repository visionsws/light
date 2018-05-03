package com.vicente.light.dto;

/**
 * @author shiweisen
 * @since 2018-02-07
 */
public class Response {

    private String responseMessage;

    public Response(String responseMessage){
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
