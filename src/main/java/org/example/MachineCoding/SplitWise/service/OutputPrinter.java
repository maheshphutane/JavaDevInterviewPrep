package org.example.MachineCoding.SplitWise.service;

public interface OutputPrinter {
    void printInvalidCommand();

    void printUserAlreadyExist();

    void printUserNotExist();

    void printUserManual();

    void printInvalidSplitDetails();

    void printUserNotExistInGivenGroup(String payee, String groupName);
}
