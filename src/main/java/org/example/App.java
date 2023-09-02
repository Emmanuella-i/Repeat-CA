package org.example;

/**
 * Hello world!
 *
 */
import DAO.IEmployeeDAOInterface;
import DAO.MysqlEmployeeDAO;
import DTO.Employee;
import Exceptions.DAOException;
import java.util.Scanner;

import java.util.List;
public class App 
{
    private static Scanner keyboard = new Scanner(System.in);
    public static void main( String[] args )
    {
        IEmployeeDAOInterface employeeDAO = new MysqlEmployeeDAO();

        System.out.println("Organisation Employee Database");
        Options selectedOption = Options.PRINT_MENU;

        boolean quit = false;
        printOptions();

        while (selectedOption != Options.QUIT) {
            System.out.print("\n Enter action: (0 to show available options) ");
            selectedOption = Options.values()[Integer.parseInt(keyboard.nextLine().trim())];
            switch (selectedOption) {
                case PRINT_MENU:
                    printOptions();
                    break;
                case FIND_AND_DISPLAY_ALL_EMPLOYEES:
                    findAndPrintAllEmployees(employeeDAO);
                    break;
                case FIND_EMPLOYEE_BY_ID:
                    findAndPrintEmployeeById(employeeDAO);
                    break;
                case FIND_AND_DISPLAY_ALL_EMPLOYEES_JSON:
                    findAllEmployeesJSON(employeeDAO);
                    break;
                case FIND_EMPLOYEE_BY_ID_JSON:
                    findEmployeeByIdJSON(employeeDAO);
                    break;
                case DELETE_EMPLOYEE_BY_ID:
                    deleteEmployeeById(employeeDAO);
                    break;
                case ADD_EMPLOYEE:

                    insertEmployee(employeeDAO);
                    break;
                case QUIT:
                    System.out.println("Shutting down simulator....");
                    quit = true;
                    break;

            }
        }







    }

    private static void printOptions()
    {
        System.out.println("\n Available options: ");
        System.out.println("0 - to print all options \n"+
                "1 -  Display all employees\n" +
                "2 -  Find Employee By ID\n" +
                "3 -  JSON Display all Employees\n" +
                "4 -  JSON Find Employee By ID\n" +
                "5 -  Delete Employee By ID\n" +
                "6 -  Add New Employee\n" +
                "7 - to quit");
    }

    private static void findEmployeeByIdJSON(IEmployeeDAOInterface employeeDAO)
    {
        try
        {
            System.out.println("Input ID: ");
            String id = keyboard.nextLine();

            String employee = employeeDAO.findEmployeeByIdJson(id);
            System.out.println(employee);

        }
        catch (DAOException e)
        {
            System.out.println("Failed to get employee " + e.getMessage());
        }


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

    private static void findAndPrintEmployeeById(IEmployeeDAOInterface employeeDAO)
    {
        try
        {
            System.out.println("Input ID: ");
            String id = keyboard.nextLine();
            Employee employee = employeeDAO.findEmployeeByID(id);
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

    private static void deleteEmployeeById(IEmployeeDAOInterface employeeDAO)
    {
        try
        {
            System.out.println("Input ID: ");
            String id = keyboard.nextLine();
            employeeDAO.deleteEmployeeByID(id);
        }
        catch (DAOException e)
        {
            System.out.println("Failed to delete Employee by id " + e.getMessage());
        }
    }

    private static void insertEmployee(IEmployeeDAOInterface employeeDAO)
    {
        try
        {

            System.out.println("Type name: ");
            String name = keyboard.nextLine();

            System.out.println("Type ID: ");
            int id = keyboard.nextInt();



            System.out.println("Type age: ");
            int age = keyboard.nextInt();

            System.out.println("Type hours worked: ");
            float hours = keyboard.nextFloat();

            Employee employee = new Employee(id, name, age, hours);
            employeeDAO.insertEmployee(employee);
        }
        catch (DAOException e)
        {
            System.out.println("Failed to insert Employee " + e.getMessage());
        }
    }


}
