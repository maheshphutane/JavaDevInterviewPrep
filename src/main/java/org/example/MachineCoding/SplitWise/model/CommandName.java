package org.example.MachineCoding.SplitWise.model;

public enum CommandName {
    EXIT("exit"),
    ADD_USER("add_user"),
    CREATE_GROUP("create_group"),
    ADD_USER_TO_GROUP("add_user_to_group"),
    ADD_EXPENSE_IN_GROUP("add_expense_in_group"),
    SHOW_GROUP_STATUS("show_group_status");
    private final String commandName;
    CommandName(String commandName){
        this.commandName = commandName;
    }
}
