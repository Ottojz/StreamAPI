package pro.sky.StreamAPIOptional.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Objects;

public class Employee {
    private final String lastName; //Базовая сложность - 4 - прямой доступ к полям класса скрыт конструкцией private
    private final String firstName; //Базовая сложность - 4 - прямой доступ к полям класса скрыт конструкцией private
    private String middleName; //Базовая сложность - 4 - прямой доступ к полям класса скрыт конструкцией private
    private String fullName; //Базовая сложность - 4 - прямой доступ к полям класса скрыт конструкцией private
    private int department; //Базовая сложность - 4 - прямой доступ к полям класса скрыт конструкцией private
    private int salary; //Базовая сложность - 4 - прямой доступ к полям класса скрыт конструкцией private
    private final int id; //Базовая сложность - 3 - добавлено поле "id" в класс Employee

    private static int counter; //Базовая сложность - 2 - добавлена статическая переменная-счетчик id

    public Employee(String lastName, String firstName, String middleName, int department, int salary) {
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.middleName = StringUtils.capitalize(middleName.toLowerCase());
        this.fullName = StringUtils.capitalize(lastName.toLowerCase()) + " " +
                StringUtils.capitalize(firstName.toLowerCase()) + " " +
                StringUtils.capitalize(middleName.toLowerCase());
        this.department = department;
        this.salary = salary;
        id = ++counter; //Базовая сложность - 3 - поле "id" проставляется из счетчика
    } //Базовая сложность - 6 - реализован конструктор, который заполняет все поля, кроме поля id, которое получает информацию из счетчика

    public Employee(String lastName, String firstName, String middleName) {
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.middleName = StringUtils.capitalize(middleName.toLowerCase());
        this.fullName = StringUtils.capitalize(lastName.toLowerCase()) + " " +
                StringUtils.capitalize(firstName.toLowerCase()) + " " +
                StringUtils.capitalize(middleName.toLowerCase());
        id = ++counter;
    }

    //Базовая сложность - 4 - на строках 35-69 реализованы геттеры всех полей и сеттеры полей ЗП и отдела
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString () {
        return this.id + "\t//\t" + this.department + "\t\t//\t" + this.salary + "   \t//\t   " + this.fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(fullName, employee.fullName);
    } //Базовая сложность - 5 - реализован контракт equals

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary, id);
    } //Базовая сложность - 5 - реализован контракт hashCode
}
