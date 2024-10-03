package org.company.util;

import org.company.entity.Employee;
import org.company.entity.Manager;
import org.company.repo.CompanyTestDatabase;
import org.company.service.EmployeeLongReportingLine;
import org.company.service.ManagerLessThanAvgSalary;
import org.company.service.ManagerMoreThanAvgSalary;

import java.util.HashSet;
import java.util.Set;

public class EmployeeTestUtil extends CompanyTestDatabase {

    public static Set<Employee> employeeSet = new HashSet<>();
    public static Set<Manager> ManagerSet = new HashSet<>();

    public static void initCollections() {
        employeeSet.add(new Employee(Long.valueOf(123), "Joe", "Doe", 60000.0, Long.valueOf(0), 0));
        employeeSet.add(new Employee(Long.valueOf(124), "Martin", "Chekov", 45000.0, Long.valueOf(123), 1));
        employeeSet.add(new Employee(Long.valueOf(300), "Alice", "Hasacat", 50000.0, Long.valueOf(124), 2));
        employeeSet.add(new Employee(Long.valueOf(305), "Brett", "Hardleaf", 24000.0, Long.valueOf(300), 3));
        employeeSet.add(new Employee(Long.valueOf(307), "Brett1", "Hardleaf1", 16000.0, Long.valueOf(305), 4));
        employeeSet.add(new Employee(Long.valueOf(308), "Brett2", "Hardleaf2", 16000.0, Long.valueOf(307), 5));

        Set<Employee> managerSetData = new HashSet<>();
        managerSetData.add(new Employee(Long.valueOf(300), "Alice", "Hasacat", 50000.0, Long.valueOf(124), 2));
        ManagerSet.add(new Manager(Long.valueOf(300), Long.valueOf(124), 45000.0, 15000.0, 0.0, true, false, managerSetData));
        initCompanyTestDataBaseByEmployees(employeeSet);
        initCompanyTestDataBaseByManagers(ManagerSet);
    }

    public static void initCompanyTestDataBaseByEmployees(Set<Employee> employeeSet) {
        addEmployees(employeeSet);
    }
    public static void initCompanyTestDataBaseByManagers(Set<Manager> managerSet) {
        addManagers(managerSet);
    }
    public static Employee createEmployee(Long id, String firstName, String lastName, Double salary, Long managerId, int count) {
        return new Employee(id, firstName, lastName, salary, managerId, count);
    }

    public static ManagerLessThanAvgSalary getManagerLessThanAvgSalary() {
        return new ManagerLessThanAvgSalary();
    }

    public static ManagerMoreThanAvgSalary getManagerMoreThanAvgSalary() {
        return new ManagerMoreThanAvgSalary();
    }

    public static EmployeeLongReportingLine getEmployeeLongReportingLine() {
        return new EmployeeLongReportingLine();
    }

    public static Set<Employee> getEmployeeSet() {
        return CompanyTestDatabase.employees;
    }
    public static Set<Manager> getManageret() {
        return CompanyTestDatabase.managers;
    }
}
