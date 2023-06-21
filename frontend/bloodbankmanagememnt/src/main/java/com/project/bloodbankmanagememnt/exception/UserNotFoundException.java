package com.project.bloodbankmanagememnt.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {super("The id does not exist:"+id);}
    public UserNotFoundException(String bloodgroup) {super("The bloodgroup does not exist:"+bloodgroup);}
}
