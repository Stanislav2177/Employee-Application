package DBUtils;

import java.util.Scanner;

public class DepartmentDBInConsole {

    private DepartmentDBUtils departmentDBUtils;

    public DepartmentDBInConsole() {
        departmentDBUtils = new DepartmentDBUtils();
        departmentDBUtils.openDB();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Create a department");
            System.out.println("2. Read departments");
            System.out.println("3. Update a department");
            System.out.println("4. Delete a department");
            System.out.println("5. Get employee information");
            System.out.println("6. Get department salary information");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Please enter the department ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Please enter the department name:");
                    String name = scanner.nextLine();

                    departmentDBUtils.create(id, name);
                    break;
                case 2:
                    System.out.println("Departments:");
                    departmentDBUtils.read().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Please enter the department ID:");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Please enter the column name to update:");
                    String columnName = scanner.nextLine();

                    System.out.println("Please enter the new value:");
                    String parameterToUpdate = scanner.nextLine();

                    departmentDBUtils.update(idToUpdate, columnName, parameterToUpdate);
                    break;
                case 4:
                    System.out.println("Please enter the department ID:");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine();

                    departmentDBUtils.delete(idToDelete);
                    break;
                case 5:
                    System.out.println("Employee information:");
                    departmentDBUtils.getEmployeeInfo();
                    break;
                case 6:
                    System.out.println("Department salary information:");
                    departmentDBUtils.getDepartmentSalary();
                    break;
                case 7:
                    departmentDBUtils.closeDB();
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        DepartmentDBInConsole menu = new DepartmentDBInConsole();
        menu.start();
    }
}

