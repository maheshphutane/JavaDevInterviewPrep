package org.example.MachineCoding.ParkingLot.services;

import org.example.MachineCoding.ParkingLot.models.Car;
import org.example.MachineCoding.ParkingLot.models.Command;
import org.example.MachineCoding.ParkingLot.models.CommandName;
import org.example.MachineCoding.ParkingLot.models.ParkingLot;
import org.example.MachineCoding.ParkingLot.outputPrinter.OutputPrinter;
import org.example.MachineCoding.ParkingLot.strategies.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutorServiceImpl implements CommandExecutorService{
    private ParkingService parkingService;
    private OutputPrinter outputPrinter;

    public CommandExecutorServiceImpl(ParkingService parkingService,OutputPrinter outputPrinter){
        this.parkingService = parkingService;
        this.outputPrinter = outputPrinter;
    }
    @Override
    public void execute(String commandLine) {
        Command command = formCommand(commandLine);
        if(command == null){
            outputPrinter.invalidCommand();
            return;
        }
        CommandName commandName = command.getCommandName();
        List<String> parameters = command.getParameters();
        switch (commandName){
            case CREATE_PARKING_LOT:
                createParkingLot(parameters);
                break;
            case PARK:
                parkCar(parameters);
                break;
            case LEAVE:
                leaveCar(parameters);
                break;
            case STATUS:
                displayStatus();
                break;
            case REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR:
                getRegistrationNumForCarsWithColor(parameters);
                break;
            case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
                getSlotNumbersForCarsWithColor(parameters);
                break;
            case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
                getSlotNumbersForRegistrationNumber(parameters);
                break;
            default:
                outputPrinter.invalidCommand();
                break;

        }
    }

    private void leaveCar(List<String> parameters) {
        if (!validateParameters(parameters)) return;
        Integer slotNumber = null;
        try {
            slotNumber = Integer.parseInt(parameters.get(0));
        }catch (IllegalArgumentException e){
            outputPrinter.invalidCommand();
            return;
        }
        parkingService.leaveCar(slotNumber);

    }

    private void getSlotNumbersForRegistrationNumber(List<String> parameters) {
        if (!validateParameters(parameters)) return;
        String registrationNumber = parameters.get(0);
        parkingService.getSlotNumberForRegistrationNumber(registrationNumber);
    }

    private void getSlotNumbersForCarsWithColor(List<String> parameters) {
        if (!validateParameters(parameters)) return;
        String color = parameters.get(0);
        parkingService.getSlotNumbersForCarsWithColor(color);
    }

    private void getRegistrationNumForCarsWithColor(List<String> parameters) {
        if (!validateParameters(parameters)) return;
        String color = parameters.get(0);
        parkingService.getRegistrationNumberWithColor(color);
    }

    private void displayStatus() {
        parkingService.status();
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

    private void parkCar(List<String> parameters) {
        if(parameters.isEmpty() || parameters.size()<2){
            outputPrinter.invalidCommand();
            return;
        }
        String registrationNumber = parameters.get(0);
        String color = parameters.get(1);

        Car carToPark = new Car(registrationNumber,color);
        parkingService.parkCar(carToPark);

    }

    private void createParkingLot(List<String> parameters) {
        if (!validateParameters(parameters)) return;
        int capacity = 0;
        try {
            capacity = Integer.parseInt(parameters.get(0));
        }catch (Exception e){
            outputPrinter.invalidCommand();
        }
        parkingService.createParkingLot(capacity);
    }
    private boolean validateParameters(List<String> parameters) {
        if (parameters.isEmpty()) {
            outputPrinter.invalidCommand();
            return false;
        }
        return true;
    }
}
