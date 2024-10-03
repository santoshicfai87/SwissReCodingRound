package org.company.main;

import org.company.entity.Employee;
import org.company.entity.Manager;
import org.company.util.EmployeeTestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class TestCompanyEmployeeStructure {

    @Before
    public void setup() {
        EmployeeTestUtil.initCollections();
    }

    @Test
    public void testEmployeeLongReportingLine() {
        Employee employee = EmployeeTestUtil.createEmployee(Long.valueOf(308), "Brett2", "Hardleaf2", 16000.0, Long.valueOf(307), 5);
        Set<Employee> employeeSet = EmployeeTestUtil.getEmployeeSet().stream()
                .filter(EmployeeTestUtil.getEmployeeLongReportingLine())
                .collect(Collectors.toSet());
        assertTrue(employeeSet.contains(employee));
    }

    @Test
    public void testManagerLessThanTheyShould() {
        Employee employee1 = EmployeeTestUtil.createEmployee(Long.valueOf(401), "Brett2", "Hardleaf2", 10000.0, Long.valueOf(307), 5);
        Employee employee2 = EmployeeTestUtil.createEmployee(Long.valueOf(402), "Brett3", "Hardleaf3", 10000.0, Long.valueOf(307), 5);
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(employee1);
        employeeSet.add(employee2);
        Manager manager = EmployeeTestUtil.createManager(Long.valueOf(307), Long.valueOf(124), 20000.0, 5000.0, 0.0, true, false, employeeSet);
        Set<Manager> managerSet = EmployeeTestUtil.getManagerSetLessThanAvgSalary().stream()
                .filter(EmployeeTestUtil.getManagerLessThanAvgSalary())
                .collect(Collectors.toSet());
        assertTrue(managerSet.contains(manager));
    }

    @Test
    public void testManagerMoreThanTheyShould() {
        Employee employee1 = EmployeeTestUtil.createEmployee(Long.valueOf(401), "Brett2", "Hardleaf2", 10000.0, Long.valueOf(307), 5);
        Employee employee2 = EmployeeTestUtil.createEmployee(Long.valueOf(402), "Brett3", "Hardleaf3", 10000.0, Long.valueOf(307), 5);
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(employee1);
        employeeSet.add(employee2);
        Manager manager = EmployeeTestUtil.createManager(Long.valueOf(307), Long.valueOf(124), 50000.0, 5000.0, 0.0, true, false, employeeSet);
        EmployeeTestUtil.getManagerSetLessThanAvgSalary();
        Set<Manager> managerSet = EmployeeTestUtil.getManagerSetMoreThanAvgSalary().stream()
                .filter(EmployeeTestUtil.getManagerMoreThanAvgSalary())
                .collect(Collectors.toSet());
        assertTrue(managerSet.contains(manager));
    }
}
