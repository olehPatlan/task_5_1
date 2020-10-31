package ua.patlan.task51;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Accountant {

    public Map<Employee, Double> calculateEmployeesSalary(List<Employee> list) {
        Map<Employee, Double> employeesSalary = new HashMap<>();
        list.forEach(employee -> employeesSalary.put(employee, employee.calculateSalary()));
        return employeesSalary;
    }

    public Map<Employee, Double> calculateEmployeesSalary(Employee... employees) {
        List<Employee> employeeList = Arrays.asList(employees);
        return calculateEmployeesSalary(employeeList);
    }
}
