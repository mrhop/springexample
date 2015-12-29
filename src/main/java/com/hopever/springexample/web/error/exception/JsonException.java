package com.hopever.springexample.web.error.exception;

/**
 * Created by Donghui Huo on 2015/12/29.
 */
public class JsonException extends RuntimeException {
    public JsonException(){
        super();
    };

    public JsonException(String message,Throwable ex){
        super(message,ex);
    }
    public JsonException(Integer code,String message,Throwable ex){
        super(code+"--"+message,ex);
    }

}
