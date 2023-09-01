package DTO;

public class Employee
{
    int employeeId;
    String name;

    int age;

    float hours;

    public Employee(String name, int age, float weight)
    {}

    public Employee(int employeeId, String name, int age, float hours)
    {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.hours = hours;
    }

    public String getName()
    {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getAge() {
        return age;
    }

    public float getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hours=" + hours +
                '}';
    }
}
