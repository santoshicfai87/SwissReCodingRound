package org.company.main;

import org.company.util.EmployeeUtil;

/**
 * THIS PROJECT FOLLOW COMPOSITE DESIGN PATTERN FOR EMPLOYEE AND MANAGER
 * COMPANYDATABASE CONTAINS ALL DATA FROM CSV FILE AND MAPPED TO ENTITY EMPLOYEE
 * THREE PREDICATES EmployeeLongReportingLine,ManagerLessThanAvgSalary,ManagerMoreThanAvgSalary COVERS GIVEN SCENARIOS
 * EmployeeUtil covers all kind of manupulation and calculations
 * PROJECT is using lombok so make sure to enable lombok in your IDE
 */
public class ApplicationLauncher {
    public static void main(String[] args) {
        EmployeeUtil.init();
        EmployeeUtil.printManagerLessThanTheyShould();
        EmployeeUtil.printManagerMoreThanTheyShould();
        EmployeeUtil.printEmployeeLongReportingLine();
    }
}
