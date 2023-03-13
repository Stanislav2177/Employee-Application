package DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDBUtils implements TaskDB {
    private Connection connection;
    private PreparedStatement statement;

    public TaskDBUtils(){

    }

    @Override
    public void openDB() {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "1234");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    public void create(int id, String title, String description, String givenAt,String dueDate,String finishedAt) {
        String sql = "INSERT INTO task (id_assigned_to, title, description, given_at , due_date) VALUES (?,?,?,?,?)";

        try{
            statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            statement.setString(2, title);
            statement.setString(3, description);
            statement.setDate(4, Date.valueOf(givenAt));
            statement.setDate(5, Date.valueOf(dueDate));


            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> read() {
        String sql = "SELECT * FROM task";

        return receiveDataFromDB(sql);
    }

    @Override
    public void update(int id, String columnName, String parameterToUpdate) {
        String sql = "UPDATE task SET " + columnName + " = '" + parameterToUpdate + "'" +
                "WHERE id_assigned_to = " + id;

        try{
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, String columnName, int parameterToUpdate) {
        String sql = "UPDATE task SET " + columnName + " = '" + parameterToUpdate + "'" +
                "WHERE id_assigned_to = " + id;

        try{
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllRows() {
        String sql = "DELETE * FROM task";

        try{
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOneRow(int id, String title) {
        String sql = "DELETE FROM task WHERE id_assigned_to = " + id + " AND title = '" + title + "'";

        try{
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> orderByIdAsc() {
        // small buttons in JavaFX
        String sql = "SELECT * FROM task ORDER BY id_assigned_to ASC";

        return receiveDataFromDB(sql);
    }

    @Override
    public List<Task> orderByIdDesc() {
        String sql = "SELECT * FROM task ORDER BY id_assigned_to DESC";

        return receiveDataFromDB(sql);
    }

    @Override
    public List<Task> displayEmployeesWithExpiredTasks() {
        String sql = "SELECT * FROM task " +
                "WHERE due_date < finished_at";

        return receiveDataFromDB(sql);
    }

    private List<Task> receiveDataFromDB(String sql){
        //To avoid repeating code i added this method
        try{
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            List<Task> list = new ArrayList<>();

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                Date givenAt = Date.valueOf(resultSet.getString(4));
                Date dueDate = Date.valueOf(resultSet.getString(5));
                String finishedAt = resultSet.getString(6);


                Task task = new Task(id, title,description,givenAt,dueDate,finishedAt);

                list.add(task);
//                System.out.println(task.toString());
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
