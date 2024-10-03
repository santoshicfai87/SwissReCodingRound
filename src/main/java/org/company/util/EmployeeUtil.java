package org.company.util;

import org.company.entity.Employee;
import org.company.entity.Manager;
import org.company.repo.CompanyDatabase;
import org.company.service.EmployeeLongReportingLine;
import org.company.service.ManagerLessThanAvgSalary;
import org.company.service.ManagerMoreThanAvgSalary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

import static org.company.config.CompanyConfig.*;

public class EmployeeUtil extends CompanyDatabase {

    public static void init() {
        loadCSVFileIntoEmployeeDatabase();
        enrichManagerSalaryIntoCompanyDatabase();
        enrichEmployeeReportingCountIntoCompanyDatabase();
    }

    private static void loadCSVFileIntoEmployeeDatabase() {
        try {
            BufferedReader lineReader = new BufferedReader(new InputStreamReader(EmployeeUtil.class.getClassLoader().getResourceAsStream(EMPLOYEE_CSV_FILE_NAME)));
            String lineText = null;
            lineReader.readLine();
            while ((lineText = lineReader.readLine()) != null) {
                String[] employeeDataArr = lineText.split(EMPLOYEE_CSV_DATA_DELIMITTER);
                Employee employee = getEmployeeEnrichedByCSVData(employeeDataArr);
                CompanyDatabase.insertEmployee(employee);
                CompanyDatabase.insertManagerIntoManagerMap(employee);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Employee getEmployeeEnrichedByCSVData(String[] employeeStringArray) {

        int size = employeeStringArray.length;

        Long id = size - EMPLOYEE_ID_INDEX > DEFAULT_SIZE ? Long.valueOf(employeeStringArray[EMPLOYEE_ID_INDEX]) : DEFAULT_EMPLOYEE_ID;
        String firstName = size - EMPLOYEE_FIRST_NAME_INDEX > DEFAULT_SIZE ? employeeStringArray[EMPLOYEE_FIRST_NAME_INDEX] : DEFAULT_EMPLOYEE_NAME;
        String lastName = size - EMPLOYEE_LAST_NAME_INDEX > DEFAULT_SIZE ? employeeStringArray[EMPLOYEE_LAST_NAME_INDEX] : DEFAULT_EMPLOYEE_NAME;
        Double salary = size - EMPLOYEE_SALARY_INDEX > DEFAULT_SIZE ? Double.valueOf(employeeStringArray[EMPLOYEE_SALARY_INDEX]) : DEFAULT_EMPLOYEE_SALARY;
        Long managerId = size - EMPLOYEE_MANAGER_ID_INDEX > DEFAULT_SIZE ? Long.valueOf(employeeStringArray[EMPLOYEE_MANAGER_ID_INDEX]) : DEFAULT_EMPLOYEE_ID;

        return new Employee(id, firstName, lastName, salary, managerId, EMPLOYEE_DEFAULT_REPORTING_COUNT);
    }

    public static void enrichManagerSalaryIntoCompanyDatabase() {
        getEmployeeList().forEach(CompanyDatabase::updateManagerintoManagerMap);
    }

    public static void enrichEmployeeReportingCountIntoCompanyDatabase() {
        for (Employee employee : CompanyDatabase.employees) {
            int count = 0;
            if (CompanyDatabase.employeeManagerMap.containsKey(employee.getManagerId())) {
                count++;
                Manager manager = CompanyDatabase.employeeManagerMap.get(employee.getManagerId());
                while (manager != null && manager.getManagerId() != DEFAULT_EMPLOYEE_ID) {
                    Long id = manager.getManagerId();
                    manager = CompanyDatabase.employeeManagerMap.get(id);
                    count++;
                }
            }
            employee.setReportingCount(count);
        }
    }

    public static Set<Employee> getEmployeeList() {
        return CompanyDatabase.employees;
    }

    public static Double getAvgSalaryOfSubOrdinatesForGivenManager(Manager manager) {
        int size = manager.getEmployeeSet().size();
        return (manager.getEmployeeSet().stream().map(Employee::getSalary).reduce(0.0, (a, b) -> a + b)) / size;
    }


    public static void printManagerLessThanTheyShould() {
        System.out.println("##########  managers earn less than they should, and by how much(minSalaryDiff) ##########");
        CompanyDatabase.employeeManagerMap.entrySet().stream()
                .map(e -> e.getValue())
                .filter(getEmployeeLessThanAvgSalary())
                .forEach(System.out::println);
    }

    public static void printManagerMoreThanTheyShould() {
        System.out.println("##########  managers earn more than they should, and by how much(maxSalaryDiff) ##########");
        CompanyDatabase.employeeManagerMap.entrySet().stream()
                .map(e -> e.getValue())
                .filter(getEmployeeMoreThanAvgSalary())
                .forEach(System.out::println);
    }

    public static void printEmployeeLongReportingLine() {
        System.out.println("########## employees have a reporting line which is too long, and by how much(reportingCount) ##########");
        CompanyDatabase.employees.stream()
                .filter(getEmployeeLongReportingLine())
                .forEach(System.out::println);
    }

    public static ManagerLessThanAvgSalary getEmployeeLessThanAvgSalary() {
        return new ManagerLessThanAvgSalary();
    }

    public static ManagerMoreThanAvgSalary getEmployeeMoreThanAvgSalary() {
        return new ManagerMoreThanAvgSalary();
    }

    public static EmployeeLongReportingLine getEmployeeLongReportingLine() {
        return new EmployeeLongReportingLine();
    }

}
