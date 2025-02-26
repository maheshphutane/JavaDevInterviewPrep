package org.example.MachineCoding.SplitWise.service;

import org.example.MachineCoding.SplitWise.controller.GroupController;
import org.example.MachineCoding.SplitWise.controller.TransactionController;
import org.example.MachineCoding.SplitWise.controller.UserController;
import org.example.MachineCoding.SplitWise.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.example.MachineCoding.SplitWise.model.CommandName.*;


public class CommandExecutorServiceImpl implements CommandExecutorService{
    private UserController userController;
    private GroupController groupController;
    private OutputPrinter outputPrinter;
    private TransactionController transactionController;
    public CommandExecutorServiceImpl(UserController userController,OutputPrinter outputPrinter,
                                      GroupController groupController,TransactionController transactionController){
        this.outputPrinter = outputPrinter;
        this.userController = userController;
        this.groupController = groupController;
        this.transactionController = transactionController;
    }
    @Override
    public void execute(String command) {
        Command command1 = formCommand(command);
        if(command1==null){
            outputPrinter.printInvalidCommand();
            return;
        }
        CommandName commandName = command1.getCommandName();
        List<String> parameters = command1.getParameters();
        switch (commandName){
            case ADD_USER:
                addUser(parameters);
                break;
            case CREATE_GROUP:
                createGroup(parameters);
                break;
            case ADD_USER_TO_GROUP:
                addUserToGroup(parameters);
                break;
            case SHOW_GROUP_STATUS:
                showGroupStatus(parameters);
                break;
            case ADD_EXPENSE_IN_GROUP:
                addExpenseInGroup(parameters);
                break;
            case SETTLE_UP:
                settleUpInGroup(parameters);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command1.getCommandName());
        }
    }

    //groupName lender borrower amount
    private void settleUpInGroup(List<String> parameters) {
        if(! isValidParameters(parameters,4)) return;
        String groupName = parameters.get(0);
        Group currGrp = groupController.getGroup(groupName);
        if(currGrp == null){
            outputPrinter.printGroupDoesNotExist();
            return;
        }
        User lender = userController.getUser(parameters.get(1));
        User borrower = userController.getUser(parameters.get(2));
        Double amount = Double.parseDouble(parameters.get(3));
        if(lender==null || borrower==null){
            outputPrinter.printUserNotExist();
            return;
        }
        currGrp.settleUP(borrower,lender,amount);
    }

    //groupName Payee Amount NoOfParticipant participantNames SplitType Split Share If any
    private void addExpenseInGroup(List<String> parameters) {
        if(! isValidParameters(parameters,6)) return;
        String groupName = parameters.get(0);
        String payee = parameters.get(1);
        if(userController.getUser(payee)==null){
            outputPrinter.printUserNotExist();
            return;
        }
        Group currGrp = groupController.getGroup(groupName);
        if(currGrp==null){
            outputPrinter.printGroupDoesNotExist();
            return;
        }
        if(!currGrp.getUserList().contains(userController.getUser(payee))){
            outputPrinter.printUserNotExistInGivenGroup(payee,groupName);
            return;
        }
        Transaction t = transactionController.createTransaction(parameters);
        if(t==null){
            outputPrinter.printInvalidCommand();
            return;
        }
        groupController.addTransactionToGroup(groupName,t);

    }

    private void showGroupStatus(List<String> parameters) {
        if(! isValidParameters(parameters,1)) return;
        groupController.showGroupStatus(parameters.get(0));
    }

    //groupName
    private void createGroup(List<String> parameters) {
        if(! isValidParameters(parameters,1)) return;
        groupController.addGroup(parameters.get(0));
    }

    //GroupName UserName
    private void addUserToGroup(List<String> parameters) {
        if(! isValidParameters(parameters,2)) return;

        String groupName = parameters.get(0);
        String userName = parameters.get(1);

        User user = userController.getUser(userName);
        if(user==null){
            outputPrinter.printUserNotExist();
        }
        groupController.addUserToGroup(groupName,user);

    }

    //UserName UserEmail
    private void addUser(List<String> parameters) {
        if(! isValidParameters(parameters,2)) return;

        userController.addUser(parameters.get(0), parameters.get(1));
    }

    private Command formCommand(String commandLine) {
        String[] args = commandLine.split(" ");
        if(args.length == 0){
            return null;
        }
        CommandName commandName = null;
        try{
            commandName = CommandName.valueOf(args[0].toUpperCase());
        }catch (IllegalArgumentException e){
            return null;
        }
        List<String> parameters = new ArrayList<>();
        if(args.length > 1){
            for(int i = 1;i< args.length;i++){
                parameters.add(args[i]);
            }
        }

        return new Command(commandName,parameters);
    }
    private boolean isValidParameters(List<String> parameters,int expectedSize){
        if(parameters.size()<expectedSize) {
            outputPrinter.printInvalidCommand();
            return false;
        }
        return true;
    }
}
