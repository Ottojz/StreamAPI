package pro.sky.StreamAPIOptional.service;

import org.springframework.stereotype.Service;
import pro.sky.StreamAPIOptional.model.Employee;

import java.util.Collection;

@Service
public interface EmployeeService {

    //Метод добавить сотрудника
    Employee add(String lastName, String firstName, String middleName, int department, int salary);

    //Метод удалить сотрудника
    Employee remove(String lastName, String firstName, String middleName, int department, int salary);

    //Метод найти сотрудника
    Employee find(String lastName, String firstName, String middleName);

    //Метод для получения списка
    Collection<Employee> getAll();
}
