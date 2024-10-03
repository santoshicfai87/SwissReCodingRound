package org.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@ToString
public class Manager {
    private Long id;
    private Long managerId;
    private Double salary;
    private Double minSalaryDiff;
    private Double maxSalaryDiff;
    private Boolean isLessThanTwentyPercentAvgSalary;
    private Boolean isMoreThanFiftyPercentAvgSalary;
    Set<Employee> employeeSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(id, manager.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}
