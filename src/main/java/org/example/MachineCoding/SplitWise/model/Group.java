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
    private  Map<WhoOwesWhom,Double> whoOwesWhomMap;

    public Group(String groupName){
        this.groupName = groupName;
        userList = new ArrayList<>();
        transactionList = new ArrayList<>();
        whoOwesWhomMap = new HashMap<>();
    }

    public void addUser(User user){
        userList.add(user);
    }

    public void addTransaction(Transaction t){
        transactionList.add(t);
        for(Map.Entry<User,Double> entry : t.getOwesToPayee().entrySet()){
            User user = entry.getKey();
            Double amount = entry.getValue();
            WhoOwesWhom curr = new WhoOwesWhom(t.getPayee(),user);
            whoOwesWhomMap.put(curr,whoOwesWhomMap.getOrDefault(curr,0.0d)+amount);
        }
    }

    public void showGroupStatus(){
        System.out.println("There are Total "+userList.size()+" User In Group "+groupName);
        for(WhoOwesWhom obj : whoOwesWhomMap.keySet()){
            System.out.println("User " + obj.getBorrower().getUserName() + " owes " + whoOwesWhomMap.get(obj) + " to " + obj.getLender().getUserName());
        }
    }

    public void settleUP(User lender, User borrower, Double amount) {
        WhoOwesWhom currObj = new WhoOwesWhom(lender,borrower);
        if(whoOwesWhomMap.containsKey(currObj)){
            double remainingAmt =  whoOwesWhomMap.get(currObj) - amount;
            if(remainingAmt==0.0d){
                whoOwesWhomMap.remove(currObj);

            }else if(remainingAmt>0){
                whoOwesWhomMap.put(currObj,Double.valueOf(String.format("%.2f", remainingAmt)));
            }else{
                System.out.println("Given amount for settle Up is greater than pending amount : "+whoOwesWhomMap.get(currObj));
                return;
            }
            System.out.println(borrower.getUserName()+" has settled up "+amount+" of "+lender.getUserName());
            System.out.println("Status of group after settle up is as below: ");
            showGroupStatus();
        }else{
            System.out.println(borrower.getUserName() +" does not borrow any money from "+lender.getUserName());
        }
    }
}
