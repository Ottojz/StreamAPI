package pro.sky.StreamAPIOptional.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.StreamAPIOptional.model.Employee;
import pro.sky.StreamAPIOptional.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam("lastName") String lastName,
            @RequestParam("firstName") String firstName,
            @RequestParam("middleName") String middleName,
            @RequestParam("department") int department,
            @RequestParam("salary") int salary) {
        return employeeService.add(lastName, firstName, middleName, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(
            @RequestParam("lastName") String lastName,
            @RequestParam("firstName") String firstName,
            @RequestParam("middleName") String middleName,
            @RequestParam("department") int department,
            @RequestParam("salary") int salary) {
        return employeeService.remove(lastName, firstName, middleName, department, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("lastName") String lastName,
            @RequestParam("firstName") String firstName,
            @RequestParam("middleName") String middleName) {
        return employeeService.find(lastName, firstName, middleName);
    }

    @GetMapping("/getAll")
    public Collection<Employee> getAll() {
        return employeeService.getAll();
    }
}