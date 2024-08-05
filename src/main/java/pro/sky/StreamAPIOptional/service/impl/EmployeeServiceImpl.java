package pro.sky.StreamAPIOptional.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.StreamAPIOptional.model.Employee;
import pro.sky.StreamAPIOptional.service.EmployeeService;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "employee1", new Employee("Иванова", "Иванна", "Петровна", 1, 51_000),
            "employee2", new Employee("Петров", "Иван", "Иванович", 3, 150_000),
            "employee3", new Employee("Сидоров", "Николай", "Владимирович", 2, 250_000),
            "employee4", new Employee("Николаев", "Марсель", "Игоревич", 3, 150_000),
            "employee5", new Employee("Вирсунгов", "Демид", "Сергеевич", 1, 150_000),
            "employee6", new Employee("Сизифов", "Николай", "Валентинович", 4, 400_000),
            "employee7", new Employee("Картаполова", "Оксана", "Вадимовна", 1, 50_000),
            "employee8", new Employee("Абрамов", "Олег", "Андреевич", 4, 200_000),
            "employee9", new Employee("Мартынов", "Павел", "Иванович", 5, 550_000),
            "employee10", new Employee("Иванов", "Иван", "Петрович", 3, 150_000)));

    @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return employees.values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
