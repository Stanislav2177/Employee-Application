package DBUtils;

import java.util.Scanner;

public class TaskDBInConsole {
    private static Scanner scanner = new Scanner(System.in);
    private static TaskDBUtils taskDB = new TaskDBUtils();

    public void start() {

        int choice;
        taskDB.openDB();

        do {
            System.out.println("MENU");
            System.out.println("1. Create a new task");
            System.out.println("2. Read all tasks");
            System.out.println("3. Update a task");
            System.out.println("4. Delete a task");
            System.out.println("5. Order tasks by ID (ascending)");
            System.out.println("6. Order tasks by ID (descending)");
            System.out.println("7. Display employees with expired tasks");
            System.out.println("8. Back to main menu");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character

                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter task given at (YYYY-MM-DD): ");
                    String givenAt = scanner.nextLine();

                    System.out.print("Enter task due date (YYYY-MM-DD): ");
                    String dueDate = scanner.nextLine();

                    taskDB.create(id, title, description, givenAt, dueDate, null);
                    break;
                case 2:
                    taskDB.read();
                    break;
                case 3:
                    System.out.print("Enter task ID: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    System.out.print("Enter the column name to update: ");
                    String columnName = scanner.nextLine();
                    System.out.print("Enter the new value: ");
                    String parameterToUpdate = scanner.nextLine();
                    taskDB.update(taskId, columnName, parameterToUpdate);
                    break;
                case 4:
                    System.out.print("Enter task ID: ");
                    int taskToDelete = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    System.out.print("Enter task title: ");
                    String titleToDelete = scanner.nextLine();
                    taskDB.deleteOneRow(taskToDelete, titleToDelete);
                    break;
                case 5:
                    taskDB.orderByIdAsc();
                    break;
                case 6:
                    taskDB.orderByIdDesc();
                    break;
                case 7:
                    taskDB.displayEmployeesWithExpiredTasks();
                    break;
                case 8:
                    Main.start();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    taskDB.closeDB();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.println();
        } while (choice != 0);
    }
}

