package DAO;

import DTO.Employee;
import Exceptions.DAOException;

import java.util.List;

public interface IEmployeeDAOInterface
{
    public List<Employee> findAllEmployees() throws DAOException, DAOException;
    public Employee findEmployeeByID(String employeeId) throws DAOException;
    public void deleteEmployeeByID(String employeeId) throws DAOException;
    public void insertEmployee(Employee employee) throws DAOException;


    String findAllEmployeesJson() throws DAOException;

    String findEmployeeByIdJson(String catId) throws DAOException;
}
