package org.example.MachineCoding.SplitWise.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Transaction {
    private User payee;
    private long amount;
    private SplitType splitType;
    private String description;
    private Map<User,Double> owesToPayee;

}
