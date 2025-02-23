package org.example.MachineCoding.SplitWise;

import org.example.MachineCoding.ParkingLot.models.CommandName;
import org.example.MachineCoding.SplitWise.controller.GroupController;
import org.example.MachineCoding.SplitWise.controller.TransactionController;
import org.example.MachineCoding.SplitWise.controller.UserController;
import org.example.MachineCoding.SplitWise.service.CommandExecutorService;
import org.example.MachineCoding.SplitWise.service.CommandExecutorServiceImpl;
import org.example.MachineCoding.SplitWise.service.OutputPrinter;
import org.example.MachineCoding.SplitWise.service.OutputPrinterImpl;

import java.util.Scanner;

public class SplitWiseMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserController userController = new UserController();
        GroupController groupController = new GroupController();
        OutputPrinter outputPrinter = new OutputPrinterImpl();
        TransactionController transactionController = new TransactionController(userController,outputPrinter);
        CommandExecutorService commandExecutor = new CommandExecutorServiceImpl(userController,outputPrinter,
                groupController,transactionController);
        outputPrinter.printUserManual();
        while(true){

            String commandLine = sc.nextLine();
            if(commandLine.equalsIgnoreCase(CommandName.EXIT.getCommandName())) break;
            commandExecutor.execute(commandLine);
        }
    }
}
