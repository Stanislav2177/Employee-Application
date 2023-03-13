package DBUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDBUtils implements DepartmentDB {

    private Connection connection;
    private PreparedStatement statement;

    public void openDB() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Successfully opened the database");
    }

    public void closeDB() {
        try {
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close the connection = " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Database is closed");
    }

    public void create(int id, String name) {
        String sql = "INSERT INTO department (id, name) VALUES (?,?)";

        try{
            statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            statement.setString(2, name);

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Department> read() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM department";

        try{
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                Department department = new Department(id, name);

                departments.add(department);
            }
            return departments;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return  null;
    }

    public void update(int id, String columnName,String parameterToUpdate) {
        String sql = "UPDATE department SET " + columnName + " = '" + parameterToUpdate + "'" +
                "WHERE id = " +id;
        try{
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM department WHERE id = " + id;
        try{
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<DepartmentSalary> getEmployeeInfo() {
        String sql = "SELECT e.id, e.full_name, d.name, AVG(e.salary) AS avg_salary " +
                "FROM employee e " +
                "JOIN department d ON e.department_id = d.id " +
                "GROUP BY d.id, e.id, e.full_name " +
                "ORDER BY d.id";

        try{
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String fullName = resultSet.getString(2);
                String department = resultSet.getString(3);
                double salary = resultSet.getDouble(4);

                EmployeeDepartment employeeDepartment = new EmployeeDepartment(id, fullName, department, salary);
                System.out.println(employeeDepartment);
            }


        }catch (SQLException e){

        }

        return null;
    }

    @Override
    public List<EmployeeDepartment> getDepartmentSalary() {
        String sql = "SELECT d.name AS department_name, AVG(e.salary) AS avg_salary " +
                "FROM employee e " +
                "JOIN department d ON e.department_id = d.id " +
                "GROUP BY d.name";

        try{
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                String department = resultSet.getString(1);
                double salary = resultSet.getDouble(2);

                DepartmentSalary departmentSalary = new DepartmentSalary(department, salary);
                System.out.println(departmentSalary);
            }
        }catch (SQLException e){
            e.printStackTrace();

        }
        return null;
    }
}

