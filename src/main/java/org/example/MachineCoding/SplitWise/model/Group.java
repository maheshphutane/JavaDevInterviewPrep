package org.example.MachineCoding.SplitWise.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Group {
    private String groupName;
    private List<User> userList;
    private List<Transaction> transactionList;

    public Group(String groupName){
        this.groupName = groupName;
        userList = new ArrayList<>();
        transactionList = new ArrayList<>();
    }

    public void addUser(User user){
        userList.add(user);
    }

    public void addTransaction(Transaction t){
        transactionList.add(t);
    }

    public void showGroupStatus(){
        System.out.println("There are Total "+userList.size()+" User In Group "+groupName);
        System.out.println("There are Total "+transactionList.size()+" Transactions In Group "+groupName);
        Map<WhoOwesWhom,Double> whoOwesWhomMap = new HashMap<>();
        for(Transaction t: transactionList){
            for(Map.Entry<User,Double> entry : t.getOwesToPayee().entrySet()){
                User user = entry.getKey();
                Double amount = entry.getValue();
                WhoOwesWhom curr = new WhoOwesWhom(t.getPayee(),user);
                whoOwesWhomMap.put(curr,whoOwesWhomMap.getOrDefault(curr,0.0d)+amount);
            }
        }
        for(WhoOwesWhom obj : whoOwesWhomMap.keySet()){
            System.out.println("User " + obj.getBorrower().getUserName() + " owes " + whoOwesWhomMap.get(obj) + " to " + obj.getLender().getUserName());
        }
    }
}
