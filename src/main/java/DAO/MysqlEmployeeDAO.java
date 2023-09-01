package DAO;
import Exceptions.DAOException;
import DTO.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlEmployeeDAO extends MysqlDAO  implements IEmployeeDAOInterface
{
    @Override
    public List<Employee> findAllEmployees() throws DAOException
    {
        List<Employee> employees = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String query = "SELECT * FROM employee";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                int employeeId = rs.getInt("employeeId");
                int age = rs.getInt("age");
                float hours = rs.getFloat("hours");
                Employee employee = new Employee(employeeId, name, age, hours);
                employees.add(employee);
            }
        }
        catch (SQLException e)
        {
            throw new DAOException("findAllEmployees() " + e.getMessage());
        }
        finally
        {
            this.freeConnection(con);
        }
        return employees;
    }



    @Override
    public Employee findEmployeeByID(String employeeId) throws DAOException {
        return null;
    }

    @Override
    public void deleteEmployeeByID(String employeeId) throws DAOException {

    }

    @Override
    public void insertEmployee(Employee employee) throws DAOException {

    }
}
