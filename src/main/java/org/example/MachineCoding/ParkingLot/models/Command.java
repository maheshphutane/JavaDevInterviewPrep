package org.example.MachineCoding.ParkingLot.models;

import lombok.Getter;

import java.util.List;
@Getter
public class Command {
    private CommandName commandName;
    private List<String> parameters;
    public Command(CommandName commandName,List<String> parameters){
        this.commandName = commandName;
        this.parameters = parameters;
    }
}
