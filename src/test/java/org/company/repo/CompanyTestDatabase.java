package org.company.repo;

import org.company.entity.Employee;
import org.company.entity.Manager;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CompanyTestDatabase {
    protected static Set<Employee> employees = new LinkedHashSet<>();
    protected static Set<Manager> managers = new LinkedHashSet<>();
    protected static Map<Long, Manager> employeeManagerMap = new HashMap<>();

    protected static void addEmployees(Set<Employee> employeesData){
        employees.addAll(employeesData);
    }

    protected static void addManagers(Set<Manager> managers){
        managers.addAll(managers);
    }
}
