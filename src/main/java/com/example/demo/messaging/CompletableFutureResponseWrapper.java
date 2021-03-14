package com.example.demo.messaging;

public class CompletableFutureResponseWrapper {

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    private  Boolean success;

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    private Object response;
}
