package com;

public record AccountRecord(int acctNo, String firstName, String lastName, double balance) {
    @Override
    public String toString() {
        return String.format("%-10d%-12s%-12s%10.2f%n", acctNo, firstName, lastName, balance);
    }
}
