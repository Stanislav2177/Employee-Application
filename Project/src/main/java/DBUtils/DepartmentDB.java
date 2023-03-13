package DBUtils;

import java.util.List;

public interface DepartmentDB {
    public void openDB();

    public void closeDB();

    public void create(int id, String name);

    public List<Department> read();

    public void update(int id, String columnName,String parameterToUpdate);

    public void delete(int id);

    public List<DepartmentSalary> getEmployeeInfo();

    public List<EmployeeDepartment> getDepartmentSalary();
}
