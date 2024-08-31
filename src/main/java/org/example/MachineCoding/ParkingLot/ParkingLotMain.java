package org.example.MachineCoding.ParkingLot;

import org.example.MachineCoding.ParkingLot.models.CommandName;
import org.example.MachineCoding.ParkingLot.outputPrinter.CommandLineOutputPrinter;
import org.example.MachineCoding.ParkingLot.outputPrinter.OutputPrinter;
import org.example.MachineCoding.ParkingLot.services.CommandExecutorService;
import org.example.MachineCoding.ParkingLot.services.CommandExecutorServiceImpl;
import org.example.MachineCoding.ParkingLot.services.ParkingService;
import org.example.MachineCoding.ParkingLot.services.ParkingServiceImpl;
import org.example.MachineCoding.ParkingLot.strategies.NearestAvailableParkingStrategy;
import org.example.MachineCoding.ParkingLot.strategies.ParkingStrategy;

import java.util.Scanner;

public class ParkingLotMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OutputPrinter outputPrinter = new CommandLineOutputPrinter();
        ParkingStrategy parkingStrategy = new NearestAvailableParkingStrategy();
        ParkingService parkingService = new ParkingServiceImpl(parkingStrategy,outputPrinter);
        CommandExecutorService commandExecutorService = new CommandExecutorServiceImpl(parkingService,outputPrinter);
        System.out.println("Enter Commands to continue..");
        while(true){
            String commandLine = sc.nextLine();
            if(commandLine.equalsIgnoreCase(CommandName.EXIT.getCommandName())) break;
            commandExecutorService.execute(commandLine);
        }
    }
}
