package org.example.MachineCoding.SplitWise.controller;

import org.example.MachineCoding.SplitWise.model.SplitType;
import org.example.MachineCoding.SplitWise.model.Transaction;
import org.example.MachineCoding.SplitWise.model.User;
import org.example.MachineCoding.SplitWise.service.OutputPrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionController {
    private UserController userController;
    private OutputPrinter outputPrinter;

    public TransactionController(UserController userController,OutputPrinter outputPrinter) {
        this.userController = userController;
        this.outputPrinter = outputPrinter;
    }

    public Transaction createTransaction(List<String> parameters) {
        String groupName = parameters.get(0);
        User payee = userController.getUser(parameters.get(1));
        long amount = Long.parseLong(parameters.get(2));
        int noOfParticipants = Integer.parseInt(parameters.get(3));
        Map<User, Double> owesToPayee = new HashMap<>();
        List<User> participants = new ArrayList<>();

        int index = 4;
        for (int i = 0; i < noOfParticipants; i++) {
            User participant = userController.getUser(parameters.get(index++));
            if(participant==null){
                return null;
            }
            participants.add(participant);

        }

        SplitType splitType = SplitType.valueOf(parameters.get(index++).toUpperCase());

        for(User u : participants){
            Double share = calculateShare(amount, noOfParticipants, parameters, index++, splitType);
            if(share==null){
                outputPrinter.printInvalidSplitDetails();
                return null;
            }
            owesToPayee.put(u,share);
        }
        String description = index < parameters.size() ? parameters.get(index) : "";

        Transaction transaction = new Transaction();
        transaction.setPayee(payee);
        transaction.setAmount(amount);
        transaction.setSplitType(splitType);
        transaction.setDescription(description);
        transaction.setOwesToPayee(owesToPayee);

        return transaction;
    }

    private Double calculateShare(long amount, int noOfParticipants, List<String> parameters, int index, SplitType splitType) {
        Double share;
        switch (splitType) {
            case EQUAL:
                share =  (double) amount / (noOfParticipants+1);
                break;
            case EXACT:
                if(index>parameters.size()){
                    return null;
                }
                share =   Double.parseDouble(parameters.get(index));
                break;
            case PERCENTAGE:
                if(index>parameters.size()){
                    return null;
                }
                share =  (amount * Double.parseDouble(parameters.get(index))) / 100;
                break;
            default:
                throw new IllegalArgumentException("Invalid SplitType");
        }
        return Math.round(share * 100.0) / 100.0;
    }
}
