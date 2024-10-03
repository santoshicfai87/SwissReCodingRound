package org.company.repo;

import org.company.entity.Employee;
import org.company.entity.Manager;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CompanyTestDatabase {
    protected static Set<Employee> employees = new LinkedHashSet<>();
    protected static Set<Manager> managersLessThanAvgSalary = new LinkedHashSet<>();
    protected static Set<Manager> managersMoreThanAvgSalary = new LinkedHashSet<>();

    protected static void addEmployees(Set<Employee> employeesData){
        employees.addAll(employeesData);
    }

    protected static void addManagersLessThanAvgSalary(Set<Manager> managerSet){
        managersLessThanAvgSalary.addAll(managerSet);
    }
    protected static void addManagersMoreThanAvgSalary(Set<Manager> managerSet){
        managersMoreThanAvgSalary.addAll(managerSet);
    }
}
