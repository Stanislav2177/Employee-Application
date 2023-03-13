package DBUtils;

//interface to provide CRUD (Create, Read, Update, and Delete) functionality for an employee database and some more.

import java.util.List;

public interface EmployeeDB {
    public void openDB();
    public void closeDB();

   public void create(int id, String fullName, String email, String phoneNumber,
                      String dateOfBirth, String dateOfAdding, double salary, int department_id);

    public List<Employee> read();
    public void update(int id, String columnName ,int parameterToUpdate);
    public void update(int id, String columnName,String parameterToUpdate);
    public void delete(int id);
    public List<Employee> displayTop5();
}
