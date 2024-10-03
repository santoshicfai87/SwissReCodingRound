package org.company.repo;

import lombok.Getter;
import org.company.config.CompanyConfig;
import org.company.entity.Employee;
import org.company.entity.Manager;

import java.util.*;

import static org.company.config.CompanyConfig.DEFAULT_EMPLOYEE_ID;
import static org.company.config.CompanyConfig.DEFAULT_EMPLOYEE_SALARY;

@Getter
public class CompanyDatabase {
    protected static Set<Employee> employees = new LinkedHashSet<>();
    protected static Set<Manager> managers = new LinkedHashSet<>();
    protected static Map<Long, Manager> employeeManagerMap = new HashMap<>();

    protected static void insertEmployee(Employee employee) {
        employees.add(employee);
    }

    protected static void updateEmployees(Set<Employee> employees) {
        employees.addAll(employees);
    }

    protected static void insertManager(Manager manager) {
        managers.add(manager);
    }

    protected static void updateManager(Set<Manager> managers) {
        managers.addAll(managers);
    }

    protected static void insertManagerIntoManagerMap(Employee employee) {
        if (employee.getManagerId() != CompanyConfig.DEFAULT_EMPLOYEE_ID) {
            employeeManagerMap.computeIfAbsent(employee.getManagerId(), k -> new Manager(employee.getManagerId(), DEFAULT_EMPLOYEE_ID, DEFAULT_EMPLOYEE_SALARY, DEFAULT_EMPLOYEE_SALARY, DEFAULT_EMPLOYEE_SALARY, false, false, new HashSet<>()));
            employeeManagerMap.get(employee.getManagerId()).getEmployeeSet().add(employee);
        } else {
            employeeManagerMap.computeIfAbsent(employee.getId(), k -> new Manager(employee.getId(), DEFAULT_EMPLOYEE_ID, DEFAULT_EMPLOYEE_SALARY, DEFAULT_EMPLOYEE_SALARY, DEFAULT_EMPLOYEE_SALARY, false, false, new HashSet<>()));
        }

    }

    protected static void updateManagerintoManagerMap(Employee employee) {
        employeeManagerMap.computeIfPresent(employee.getId(), (k, v) -> {
            v.setSalary(employee.getSalary());
            v.setManagerId(employee.getManagerId());
            return v;
        });
    }
/*    public static Manager getManagerForEmployee(Employee employee) {
        employeeManagerMap.computeIfAbsent(employee, k -> new Manager(employee.getManagerId(), DEFAULT_EMPLOYEE_SALARY, false, false, Collections.emptySet()));
        return employeeManagerMap.get(employee);
    }*/
}
