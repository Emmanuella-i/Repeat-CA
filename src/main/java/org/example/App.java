package org.example;

/**
 * Hello world!
 *
 */
import DAO.IEmployeeDAOInterface;
import DAO.MysqlEmployeeDAO;
import DTO.Employee;
import Exceptions.DAOException;

import java.util.List;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        IEmployeeDAOInterface employeeDAO = new MysqlEmployeeDAO();
        findAndPrintAllEmployees(employeeDAO);
        findAndPrintEmployeeById(employeeDAO, "1");
        deleteEmployeeById(employeeDAO, "1");
        //insertEmployee(employeeDAO, );
        findAllEmployeesJSON(employeeDAO);
    }

    private static void findAllEmployeesJSON(IEmployeeDAOInterface employeeDAO)
    {
        try
        {
            String employees = employeeDAO.findAllEmployeesJson();

                System.out.println(employees);

        }
        catch (DAOException e)
        {
            System.out.println("Failed to get all employees " + e.getMessage());
        }
    }

    private static void findAndPrintEmployeeById(IEmployeeDAOInterface employeeDAO, String employeeId)
    {
        try
        {
            Employee employee = employeeDAO.findEmployeeByID(employeeId);
            System.out.println(employee);
        }
        catch (DAOException e)
        {
            System.out.println("Failed to get employee by id " + e.getMessage());
        }
    }


    private static void findAndPrintAllEmployees(IEmployeeDAOInterface employeeDAO)
    {
        try
        {
            List<Employee> employees = employeeDAO.findAllEmployees();
            for (Employee employee : employees)
            {
                System.out.println(employee);
            }
        }
        catch (DAOException e)
        {
            System.out.println("Failed to get all employees " + e.getMessage());
        }
    }

    private static void deleteEmployeeById(IEmployeeDAOInterface employeeDAO, String employeeId)
    {
        try
        {
            employeeDAO.deleteEmployeeByID(employeeId);
        }
        catch (DAOException e)
        {
            System.out.println("Failed to delete Employee by id " + e.getMessage());
        }
    }

    private static void insertEmployee(IEmployeeDAOInterface employeeDAO, Employee employee)
    {
        try
        {
            employeeDAO.insertEmployee(employee);
        }
        catch (DAOException e)
        {
            System.out.println("Failed to insert Employee " + e.getMessage());
        }
    }


}
