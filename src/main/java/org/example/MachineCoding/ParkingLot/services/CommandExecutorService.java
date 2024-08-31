package org.example.MachineCoding.ParkingLot.services;

import org.example.MachineCoding.ParkingLot.models.Command;

public interface CommandExecutorService {
    void execute(String command);
}
