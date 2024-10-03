package org.company.config;

public interface CompanyConfig {
    public static String EMPLOYEE_CSV_FILE_NAME = "employee.csv";
    public static String EMPLOYEE_CSV_DATA_DELIMITTER = ",";
    public static String DEFAULT_EMPLOYEE_NAME = "";
    public static long DEFAULT_EMPLOYEE_ID = 0;
    public static Double DEFAULT_EMPLOYEE_SALARY = 0.0;
    public static int DEFAULT_SIZE = 0;
    public static int EMPLOYEE_ID_INDEX = 0;
    public static int EMPLOYEE_FIRST_NAME_INDEX = 1;
    public static int EMPLOYEE_LAST_NAME_INDEX = 2;
    public static int EMPLOYEE_SALARY_INDEX = 3;
    public static int EMPLOYEE_MANAGER_ID_INDEX = 4;
    public static int EMPLOYEE_LEAST_SALARY_DENOMINATOR=5;
    public static int EMPLOYEE_MAX_SALARY_DENOMINATOR=2;
    public static int EMPLOYEE_DEFAULT_REPORTING_COUNT=0;
    public static int EMPLOYEE_MAX_REPORTING_COUNT=4;
}
