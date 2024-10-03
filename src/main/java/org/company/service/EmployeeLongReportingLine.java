package org.company.service;

import org.company.entity.Employee;

import java.util.function.Predicate;

import static org.company.config.CompanyConfig.EMPLOYEE_MAX_REPORTING_COUNT;

public class EmployeeLongReportingLine implements Predicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getReportingCount() > EMPLOYEE_MAX_REPORTING_COUNT;
    }
}
