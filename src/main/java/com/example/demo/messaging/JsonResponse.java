package com.example.demo.messaging;

public class JsonResponse {
    private String process;
    private Boolean state;
    private String detail;


    public JsonResponse(String process, Boolean state, String detail){
        this.process = process;
        this.state = state;
        this.detail= detail;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
