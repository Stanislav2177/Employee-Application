package DBUtils;

import java.util.List;

public interface TaskDB {
    public void openDB();
    public void closeDB();
    public void create(int id, String title, String description,String givenAt, String dueDate, String finishedAt);
    public List<Task> read();
    public void update(int id, String columnName, String parameterToUpdate);
    public void update(int id, String columnName, int parameterToUpdate);
    public void deleteOneRow(int id, String title);
    public void deleteAllRows();
    public List<Task> orderByIdAsc();
    public List<Task> orderByIdDesc();
    public List<Task> displayEmployeesWithExpiredTasks();

}
