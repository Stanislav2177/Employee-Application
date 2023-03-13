package DBUtils;

import java.util.Date;

public class Employee {
    private int id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private Date dateOfAdding;
    private double salary;
    private int completedTasks;
    private int department;

    public Employee(int id, String fullName, String email, String phoneNumber,
                    Date dateOfBirth, Date dateOfAdding, double salary, int completedTasks, int department) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAdding = dateOfAdding;
        this.salary = salary;
        this.completedTasks = completedTasks;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfAdding() {
        return dateOfAdding;
    }

    public void setDateOfAdding(Date dateOfAdding) {
        this.dateOfAdding = dateOfAdding;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(int completedTasks) {
        this.completedTasks = completedTasks;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public String toString() {
        /*
         Using StringBuilder to construct the Employee representation for
         better performance, because using a String.format(), object is created
         each time, which can be slow and waste of memory. The performance
         improvements may be relatively small in this case, since the number of
         objects being processed is likely to be relatively small. But in
         bigger data load, this could show some improvements

         */
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id)
                .append(", name: ").append(fullName)
                .append(", email: ").append(email)
                .append(", phone: ").append(phoneNumber)
                .append(", date of birth: ").append(dateOfBirth)
                .append(", date of adding: ").append(dateOfAdding)
                .append(", salary: ").append(salary)
                .append(", completed tasks: ").append(completedTasks)
                .append(", department: ").append(department);
        return sb.toString();
    }
}
