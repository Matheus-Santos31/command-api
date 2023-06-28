package com.example.commandbackend.Commom.BaseRequestResult;

import org.springframework.http.HttpStatus;

public class BaseRequestResult<T>{
    public HttpStatus status;
    public int statusCode;
    public String message;
    public T data = null;

    public BaseRequestResult(HttpStatus status,int statusCode, String message, T data) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public BaseRequestResult(HttpStatus status,int statusCode, String message) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
    }
}
