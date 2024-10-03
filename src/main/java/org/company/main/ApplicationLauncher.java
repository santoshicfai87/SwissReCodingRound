package org.company.main;

import org.company.util.EmployeeUtil;

/**
 * THIS PROJECT FOLLOW COMPOSITE DESIGN PATTERN FOR EMPLOYEE AND MANAGER
 * CompanyDatabase CONTAINS ALL DATA FROM CSV FILE AND MAPPED TO ENTITY EMPLOYEE
 * THREE PREDICATES EmployeeLongReportingLine,ManagerLessThanAvgSalary,ManagerMoreThanAvgSalary COVERS GIVEN SCENARIOS
 * EmployeeUtil covers all kind of manupulation and calculations
 * PROJECT IS USING LOMBOK SO MAKE SURE TO ENABLE LOMBOK IN YOUR IDE
 */
public class ApplicationLauncher {
    public static void main(String[] args) {
        EmployeeUtil.init();
        EmployeeUtil.printManagerLessThanTheyShould();
        EmployeeUtil.printManagerMoreThanTheyShould();
        EmployeeUtil.printEmployeeLongReportingLine();
    }
}
