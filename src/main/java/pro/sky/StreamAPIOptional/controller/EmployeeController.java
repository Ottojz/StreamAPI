package pro.sky.StreamAPIOptional.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.StreamAPIOptional.model.Employee;
import pro.sky.StreamAPIOptional.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary (int departmentId) {
        return employeeService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary (int departmentId) {
        return employeeService.getEmployeeWithMinSalary(departmentId);
    }
    @GetMapping("/all")
    public List<Employee> getAllEmployees (int departmentId) {
        return employeeService.getAllEmployees(departmentId);
    }
    @GetMapping("/alldepartments")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return employeeService.getAllEmployeesByDepartment();
    }
}
