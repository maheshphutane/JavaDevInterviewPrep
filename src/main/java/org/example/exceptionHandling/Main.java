package org.example.exceptionHandling;

public class Main {
    public static void main(String[] args){
        try {
            System.out.println("I'm trying if Exception occur or not");
            throw new CustomException("This is custom exception");
            //throw new RuntimeException("This is predefined Exception");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
