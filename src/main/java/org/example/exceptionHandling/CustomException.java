package org.example.exceptionHandling;

public class CustomException extends Exception {
    public CustomException(){
        super();
    }

    public CustomException(String msg){
        super(msg);
    }
}
