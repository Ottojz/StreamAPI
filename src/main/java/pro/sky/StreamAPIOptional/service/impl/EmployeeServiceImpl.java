package pro.sky.StreamAPIOptional.service.impl;

import org.springframework.stereotype.Component;
import pro.sky.StreamAPIOptional.exceptions.EmployeeAlreadyAddedException;
import pro.sky.StreamAPIOptional.exceptions.EmployeeNotFoundException;
import pro.sky.StreamAPIOptional.model.Employee;
import pro.sky.StreamAPIOptional.service.EmployeeService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "employee1", new Employee("Ivanova", "Ivanna", "Petrovna", 1, 51_000),
            "employee2", new Employee("Петров", "Иван", "Иванович", 3, 150_000),
            "employee3", new Employee("Сидоров", "Николай", "Владимирович", 2, 250_000),
            "employee4", new Employee("Николаев", "Марсель", "Игоревич", 3, 150_000),
            "employee5", new Employee("Вирсунгов", "Демид", "Сергеевич", 1, 150_000),
            "employee6", new Employee("Сизифов", "Николай", "Валентинович", 4, 400_000),
            "employee7", new Employee("Картаполова", "Оксана", "Вадимовна", 1, 50_000),
            "employee8", new Employee("Абрамов", "Олег", "Андреевич", 4, 200_000),
            "employee9", new Employee("Мартынов", "Павел", "Иванович", 5, 550_000),
            "employee10", new Employee("Иванов", "Иван", "Петрович", 3, 150_000)));
    private final int maxSize = 15;

    @Override
    public Employee add(String lastName, String firstName, String middleName, int department, int salary) {
        Employee employee = new Employee(lastName, firstName, middleName, department, salary);
        if (employees.size() > maxSize){
            throw new EmployeeNotFoundException("Достигнут лимит количества сотрудников в фирме");
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже зарегистрирован");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String lastName, String firstName, String middleName, int department, int salary) {
        Employee employee = new Employee(lastName, firstName, middleName, department, salary);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Данный сотрудник не найден");
        }
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        return null;
    }

    @Override
    public Employee find(String lastName, String firstName, String middleName) {
        Employee employee = new Employee(lastName, firstName, middleName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Данный сотрудник не найден");
        }
        return employee;
    }

    @Override
    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
