package model.service;

public class NotEnoughDetailsException extends Exception{
    public NotEnoughDetailsException(String message){
        super(message);
    }
}
