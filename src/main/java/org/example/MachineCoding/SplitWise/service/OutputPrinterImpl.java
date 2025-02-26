package org.example.MachineCoding.SplitWise.service;

public class OutputPrinterImpl implements OutputPrinter{
    @Override
    public void printInvalidCommand() {
        System.out.println("Please Enter Valid Command");
    }

    @Override
    public void printUserAlreadyExist() {
        System.out.println("User Already Exist, Please Enter Another UserName");
    }

    @Override
    public void printUserNotExist() {
        System.out.println("User Not Exist, Please Register user first");
    }

    @Override
    public void printUserManual() {
        System.out.println("Available Commands:");
        System.out.println("1. ADD_USER <UserName> <UserEmail>");
        System.out.println("2. CREATE_GROUP <GroupName>");
        System.out.println("3. ADD_USER_TO_GROUP <GroupName> <UserName>");
        System.out.println("4. ADD_EXPENSE_IN_GROUP <GroupName> <Payee> <Amount> <NoOfParticipants> <ParticipantNames> <SplitType> <SplitShareIfAny>");
        System.out.println("5. SHOW_GROUP_STATUS <GroupName>");
        System.out.println("6. SETTLE_UP <GroupName> <borrower> <lender> <amount>");
        System.out.println("7. EXIT");
    }

    @Override
    public void printInvalidSplitDetails() {
        System.out.println("Please provide valid command with correct split details of the transaction");
    }

    @Override
    public void printUserNotExistInGivenGroup(String payee, String groupName) {
        System.out.println(payee+ " is Not present in group "+groupName);
    }

    @Override
    public void printGroupDoesNotExist() {
        System.out.println("Given Group Dose Not Exist :)");
    }

}
