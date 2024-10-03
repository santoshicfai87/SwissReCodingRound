package org.company.main;

import org.company.entity.Employee;
import org.company.entity.Manager;
import org.company.util.EmployeeTestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
        Employee employee = EmployeeTestUtil.createEmployee(Long.valueOf(308), "Brett2", "Hardleaf2", 16000.0, Long.valueOf(307), 5);
        Set<Manager> managerSet = EmployeeTestUtil.getManageret().stream()
                .filter(EmployeeTestUtil.getManagerLessThanAvgSalary())
                .collect(Collectors.toSet());
        assertTrue(!managerSet.contains(employee));
    }

    @Test
    public void testManagerMoreThanTheyShould() {
        Employee employee = EmployeeTestUtil.createEmployee(Long.valueOf(309), "Brett2", "Hardleaf2", 16000.0, Long.valueOf(307), 5);
        Set<Manager> managerSet = EmployeeTestUtil.getManageret().stream()
                .filter(EmployeeTestUtil.getManagerMoreThanAvgSalary())
                .collect(Collectors.toSet());
        assertTrue(!managerSet.contains(employee));
    }
}
