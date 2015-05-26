package com.appdirect.demo.controller;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {

    private boolean success;
    private String errorCode;
    private String accountIdentifier;

    public Response() {
    }

    public Response(Boolean success, String errorCode, String accountIdentifier) {
        this.success = success;
        this.errorCode = errorCode;
        this.accountIdentifier = accountIdentifier;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }
}
