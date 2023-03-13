package DBUtils;

import java.util.Scanner;

public class EmployeeDBInConsole {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeDBUtils employeeDB = new EmployeeDBUtils();

    public void start(){
        int choice = -1;
        employeeDB.openDB();
        while (choice != 0) {
            System.out.println("\nEmployee Database Menu:");
            System.out.println("1. Add employee");
            System.out.println("2. View all employees");
            System.out.println("3. Update employee");
            System.out.println("4. Delete employee");
            System.out.println("5. Display top 5 employees with most completed tasks");
            System.out.println("6. Back to main menu");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter employee full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter employee email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter employee phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter employee date of birth (YYYY-MM-DD): ");
                    String dateOfBirth = scanner.nextLine();
                    System.out.print("Enter employee date of adding (YYYY-MM-DD): ");
                    String dateOfAdding = scanner.nextLine();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Enter employee department_id: ");
                    int department_id = scanner.nextInt();
                    scanner.nextLine();

                    employeeDB.create(id, fullName, email, phoneNumber, dateOfBirth, dateOfAdding, salary,department_id);
                    break;
                case 2:
                    employeeDB.read();
                    break;
                case 3:
                    System.out.print("Enter employee ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter column name to update: ");
                    String columnName = scanner.nextLine();
                    System.out.print("Enter new value: ");
                    String parameterToUpdate = scanner.nextLine();
                    employeeDB.update(updateId, columnName, parameterToUpdate);
                    break;
                case 4:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    employeeDB.delete(deleteId);
                    break;
                case 5:
                    employeeDB.displayTop5();
                    break;

                case 6:
                    Main.start();
                    employeeDB.closeDB();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    employeeDB.closeDB();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
        scanner.close();
    }
}



