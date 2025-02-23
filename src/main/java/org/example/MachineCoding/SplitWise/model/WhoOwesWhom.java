package org.example.MachineCoding.SplitWise.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class WhoOwesWhom {
    private User lender;
    private User borrower;
    public WhoOwesWhom(User lender,User borrower){
        this.lender = lender;
        this.borrower = borrower;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WhoOwesWhom user = (WhoOwesWhom) o;
        return Objects.equals(lender, user.lender) && Objects.equals(borrower, user.borrower);
    }
    @Override
    public int hashCode(){
        return Objects.hash(lender,borrower);
    }
}
