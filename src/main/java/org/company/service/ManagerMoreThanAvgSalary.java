package org.company.service;

import org.company.config.CompanyConfig;
import org.company.entity.Manager;
import org.company.util.EmployeeUtil;

import java.util.function.Predicate;

public class ManagerMoreThanAvgSalary implements Predicate<Manager> {
    @Override
    public boolean test(Manager manager) {
        Double avgSalary = EmployeeUtil.getAvgSalaryOfSubOrdinatesForGivenManager(manager);
        Double maxSalary = avgSalary + (avgSalary / CompanyConfig.EMPLOYEE_MAX_SALARY_DENOMINATOR);
        if (manager.getSalary() > maxSalary) {
            manager.setMaxSalaryDiff(manager.getSalary() - maxSalary);
            manager.setIsLessThanTwentyPercentAvgSalary(false);
            manager.setIsMoreThanFiftyPercentAvgSalary(true);
        }
        return manager.getMaxSalaryDiff() > 0;
    }
}