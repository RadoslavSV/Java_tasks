package com;

import java.io.Serializable;

public record EmployeeRecord (
        Long id,
        String firstName,
        String lastName,
        String email,
        int age) implements Serializable
{

}
