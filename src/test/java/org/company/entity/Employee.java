package org.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Data
@ToString
@AllArgsConstructor
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private Double salary;
    private Long managerId;
    private int reportingCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(salary, employee.salary) && Objects.equals(managerId, employee.managerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, salary, managerId);
    }

}