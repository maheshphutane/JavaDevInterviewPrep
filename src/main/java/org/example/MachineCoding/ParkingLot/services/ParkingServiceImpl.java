package org.example.MachineCoding.ParkingLot.services;

import org.example.MachineCoding.ParkingLot.models.Car;
import org.example.MachineCoding.ParkingLot.models.ParkingLot;
import org.example.MachineCoding.ParkingLot.models.Slot;
import org.example.MachineCoding.ParkingLot.outputPrinter.OutputPrinter;
import org.example.MachineCoding.ParkingLot.strategies.ParkingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingServiceImpl implements ParkingService{
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;
    private OutputPrinter outputPrinter;
    public ParkingServiceImpl( ParkingStrategy parkingStrategy, OutputPrinter outputPrinter){
        this.parkingStrategy = parkingStrategy;
        this.outputPrinter = outputPrinter;
    }

    @Override
    public void createParkingLot(int capacity) {
        this.parkingLot = new ParkingLot(capacity);
        outputPrinter.parkingLotCreated(capacity);
    }

    @Override
    public void parkCar(Car car) {
        if(isParkingLotNotCreated(parkingLot)) return;
        Slot availableSlot = parkingStrategy.availableSlot(parkingLot);
        if(availableSlot==null){
            outputPrinter.noFreeSpaceAvailable();
            return;
        }
        availableSlot.parkCar(car);
        outputPrinter.carIsParked(availableSlot.getSlotNumber());
    }

    @Override
    public void removeCar(int slotNumber) {
        if(isParkingLotNotCreated(parkingLot)) return;
        Slot[] slots = parkingLot.getSlots();
        if(slotNumber<0 || slotNumber>slots.length){
            outputPrinter.invalidSlotNumber();
            return;
        }
        Slot occupiedSlot = slots[slotNumber-1];
        occupiedSlot.removeCar();
        outputPrinter.carIsParked(slotNumber);
    }

    @Override
    public void status() {
        if(isParkingLotNotCreated(parkingLot)) return;
        Slot[] slots = parkingLot.getSlots();
        if(slots.length == 0){
            outputPrinter.parkingLotIsEmpty();
            return;
        }
        outputPrinter.printStatus(slots);

    }

    @Override
    public void getRegistrationNumberWithColor( String color) {
        if(isParkingLotNotCreated(parkingLot)) return;
        List<String> carsWithGivenColor = Arrays.stream(parkingLot.getSlots())
                .filter(s -> s.getCar()!=null)
                .filter(s -> s.getCar().getColor().equalsIgnoreCase(color))
                .map(s -> s.getCar().getRegistrationNumber())
                .toList();

        outputPrinter.printRegistrationNumbers(carsWithGivenColor);

    }

    @Override
    public void getSlotNumberForRegistrationNumber(String registrationNumber) {
        if(isParkingLotNotCreated(parkingLot)) return;
        for(Slot s: parkingLot.getSlots()){
            if(s.getCar()!=null && s.getCar().getRegistrationNumber().equalsIgnoreCase(registrationNumber)){
                outputPrinter.carIsParked(s.getSlotNumber());
                return;
            }
        }
        outputPrinter.notFound();
    }

    @Override
    public void getSlotNumbersForCarsWithColor(String color) {
        if (isParkingLotNotCreated(parkingLot)) return;
        List<Integer> slotNumbers = Arrays.stream(parkingLot.getSlots())
                .filter(slot -> slot.getCar() != null)
                .filter(slot -> slot.getCar().getColor().equalsIgnoreCase(color))
                .map(Slot::getSlotNumber)
                .collect(Collectors.toList());

        outputPrinter.printSlotNumbers(slotNumbers);
    }

    @Override
    public void leaveCar(Integer slotNumber) {
        if (isParkingLotNotCreated(parkingLot)) return;
        Slot[] slots = parkingLot.getSlots();
        for(Slot s:slots){
            if(s.getSlotNumber() == slotNumber && s.isOccupied()){
                s.removeCar();
                outputPrinter.printCarRemovedOn(s.getSlotNumber());
                return;
            }
        }
        outputPrinter.notFound();
    }


    private boolean isParkingLotNotCreated(ParkingLot parkingLot) {
        if(parkingLot == null){
            outputPrinter.noParkingLotFound();
            return true;
        }
        return false;
    }
}
