package org.example.MachineCoding.SplitWise.controller;


import lombok.Getter;
import org.example.MachineCoding.SplitWise.model.User;

import java.util.HashMap;
import java.util.Map;

@Getter
public class UserController {
    private Map<String, User> userMap;
    public UserController(){
        userMap = new HashMap<>();
    }
    public void addUser(String userName,String userEmail){
        userMap.put(userName,new User(userName,userEmail));
    }
    public User getUser(String userName){
        return userMap.get(userName);
    }
}
