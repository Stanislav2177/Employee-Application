package DBUtils;//1 - add jdbc to Project Structure/Libraries and then choose it.


import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDBUtils implements EmployeeDB {
    TaskDBUtils taskDBUtils = new TaskDBUtils();
    private Connection connection;
    private PreparedStatement statement;

    @Override
    public void openDB() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Successfully is opened the database");
    }

    @Override
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

    @Override
    public void create(int id, String fullName, String email,
                       String phoneNumber, String dateOfBirth, String dateOfAdding, double salary, int department_id) {
        String sql = "INSERT INTO employee (id, full_name, email, phone_number," +
                " date_of_birth, date_of_adding, salary, completed_tasks, department_id) VALUES (?,?,?,?,?,?,?,?,?)";

        try{
            statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            statement.setString(2, fullName);
            statement.setString(3, email);
            statement.setString(4, phoneNumber);
            statement.setDate(5, java.sql.Date.valueOf(dateOfBirth));
            statement.setDate(6, java.sql.Date.valueOf(dateOfAdding));
            statement.setDouble(7, salary);
            statement.setInt(8, 0);
            statement.setInt(9, department_id);

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> read() {
        String sql = "SELECT * FROM employee";

        try{
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            List<Employee> list = new ArrayList<>();

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String phoneNumber = resultSet.getString(4);
                java.sql.Date dateOfBirth = resultSet.getDate(5);
                java.sql.Date dateOfAdding = resultSet.getDate(6);
                double salary = resultSet.getDouble(7);
                int completedTasks = resultSet.getInt(8);
                int department = resultSet.getInt(9);

                Employee employee = new Employee(id, name, email,phoneNumber, dateOfBirth, dateOfAdding, salary, completedTasks, department);

                list.add(employee);
//                System.out.println(employee.toString());
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(int id, String columnName,int parameterToUpdate) {
        String sql = "UPDATE employee SET " + columnName + " = '" + parameterToUpdate + "'" +
                "WHERE id = " +id;

        try{
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, String columnName,String parameterToUpdate) {
        String sql = "UPDATE employee SET " + columnName + " = '" + parameterToUpdate + "'" +
                "WHERE id = " +id;
        try{
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        /*
        To achieve deleting from employee table, need also row or even rows
        from task table to be deleted also. That is because the ids from both
        tables are connected via primary -> foreign key.
         */
//        taskDBUtils.deleteAllRows(id);
        String sql = "DELETE FROM employee WHERE id = " + id;
        try{
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> displayTop5() {
        String getMonth = getPastMonth();
        try{
            String sql = "{CALL getCompletedTasksByEmployee(?)}";

            CallableStatement stmt = connection.prepareCall(sql);

            stmt.setDate(1, java.sql.Date.valueOf(getMonth));

            ResultSet resultSet = stmt.executeQuery();

            List<Employee> list = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String phoneNumber = resultSet.getString(4);
                Date dateOfBirth = resultSet.getDate(5);
                Date dateOfAdding = resultSet.getDate(6);
                double salary = resultSet.getDouble(7);
                int completedTasks = resultSet.getInt(8);
                int department_id = resultSet.getInt(9);

                Employee employee = new Employee(id, name, email,phoneNumber,dateOfBirth,dateOfAdding,salary,completedTasks,department_id);
                list.add(employee);
            }
            resultSet.close();
            stmt.close();
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private String getPastMonth() {
        LocalDate currentDate = LocalDate.now();
        LocalDate prevMonthDate = currentDate.minusMonths(1).withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String prevMonthDateString = prevMonthDate.format(formatter);
        return prevMonthDateString;
    }

}
