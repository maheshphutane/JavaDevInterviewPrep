package org.example.MachineCoding.ParkingLot.outputPrinter;

import org.example.MachineCoding.ParkingLot.models.ParkingLot;
import org.example.MachineCoding.ParkingLot.models.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class CommandLineOutputPrinter implements OutputPrinter{
    @Override
    public void noFreeSpaceAvailable() {
        System.out.println("Sorry, parking lot is full");
    }

    @Override
    public void carIsParked(int slotNumber) {
        System.out.println("Allocated slot number:: "+slotNumber);
    }

    @Override
    public void invalidSlotNumber() {
        System.out.println("Not Found");
    }

    @Override
    public void invalidCommand() {
        System.out.println("Invalid Command");
    }

    @Override
    public void parkingLotCreated(int capacity) {
        System.out.println("Created a parking lot with " +capacity+ " slots");
    }

    @Override
    public void noParkingLotFound() {
        System.out.println("Please create Parking Lot First!!");
    }

    @Override
    public void parkingLotIsEmpty() {
        System.out.println("Parking Lot is Empty..");
    }

    @Override
    public void printStatus(Slot[] slots) {
        System.out.println("Slot No. | RegistrationNumber | Color");
        for(Slot s: slots){
            if(s.getCar()!=null) {
                System.out.printf("  %-7d| %-18s| %s%n", s.getSlotNumber(), s.getCar().getRegistrationNumber(), s.getCar().getColor());
            }
        }
    }

    @Override
    public void printRegistrationNumbers(List<String> carsWithGivenColor) {
        if(carsWithGivenColor.isEmpty()){
            System.out.println("No cars found of given Color.");
        }else{
            System.out.println(String.join(", ", carsWithGivenColor));
        }

    }

    @Override
    public void printSlotNumbers(List<Integer> slotNumbers) {
        if (slotNumbers.isEmpty()) {
            System.out.println("No cars found of given Color.");
        } else {
            System.out.println(slotNumbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }

    @Override
    public void printCarRemovedOn(int slotNumber) {
        System.out.println("Slot number " +  slotNumber + " is free");
    }

    @Override
    public void notFound() {
        System.out.println("Not Found.");
    }

}
