package org.example.MachineCoding.ParkingLot.models;

import lombok.Getter;

@Getter
public enum CommandName {
    EXIT("exit"),
    STATUS("status"),
    LEAVE("leave"),
    PARK("park"),
    REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR("registration_numbers_for_cars_with_colour"),
    SLOT_NUMBER_FOR_REGISTRATION_NUMBER("slot_number_for_registration_number"),
    SLOT_NUMBERS_FOR_CARS_WITH_COLOUR("slot_numbers_for_cars_with_colour"),
    CREATE_PARKING_LOT("create_parking_lot");
    private final String commandName;
    CommandName(String commandName){
        this.commandName = commandName;
    }

}
