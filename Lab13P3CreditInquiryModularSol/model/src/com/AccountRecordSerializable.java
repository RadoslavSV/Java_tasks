package com;

import java.io.Serializable;

public record AccountRecordSerializable(int acct, String first, String last, double bal )
implements Serializable {
    @Override
    public String toString() {
        return String.format("%-10d%-12s%-12s%10.2f%n", acct, first,last, bal );
    }
}
