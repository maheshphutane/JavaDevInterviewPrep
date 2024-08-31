package org.example.MachineCoding.ParkingLot.outputPrinter;

import org.example.MachineCoding.ParkingLot.models.Slot;

import java.util.List;

public interface OutputPrinter {
    void noFreeSpaceAvailable();
    void carIsParked(int slotNumber);

    void invalidSlotNumber();

    void invalidCommand();

    void parkingLotCreated(int capacity);

    void noParkingLotFound();

    void parkingLotIsEmpty();

    void printStatus(Slot[] slots);

    void printRegistrationNumbers(List<String> carsWithGivenColor);

    void notFound();
    void printSlotNumbers(List<Integer> slotNumbers);

    void printCarRemovedOn(int slotNumber);
}
