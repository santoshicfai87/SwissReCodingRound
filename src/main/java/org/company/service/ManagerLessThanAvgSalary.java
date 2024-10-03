package org.company.service;

import org.company.config.CompanyConfig;
import org.company.entity.Manager;
import org.company.util.EmployeeUtil;

import java.util.function.Predicate;

public class ManagerLessThanAvgSalary implements Predicate<Manager> {

    @Override
    public boolean test(Manager manager) {
        Double avgSalary = EmployeeUtil.getAvgSalaryOfSubOrdinatesForGivenManager(manager);
        Double leastSalary = avgSalary + (avgSalary / CompanyConfig.EMPLOYEE_LEAST_SALARY_DENOMINATOR);
        if (manager.getSalary() < leastSalary) {
            manager.setMinSalaryDiff(leastSalary - manager.getSalary());
            manager.setIsLessThanTwentyPercentAvgSalary(true);
            manager.setIsMoreThanFiftyPercentAvgSalary(false);
        }
        return manager.getMinSalaryDiff() > 0;
    }
}