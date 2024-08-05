package pro.sky.StreamAPIOptional.service;

import pro.sky.StreamAPIOptional.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee getEmployeeWithMaxSalary (int department);
    Employee getEmployeeWithMinSalary (int department);

    List<Employee> getAllEmployees (int department);

    Map<Integer, List<Employee>> getAllEmployeesByDepartment();

}
