import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a task
class Task {
    private String title;
    private String description;
    private String dueDate;
    private boolean isComplete;

    public Task(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void markComplete() {
        this.isComplete = true;
    }

    public String toString() {
        return (isComplete ? "[✓] " : "[ ] ") + title + " - " + description + " (Due: " + dueDate + ")";
    }
}

// Main class for the To-Do List application
public class ToDoList {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    public ToDoList() {
        tasks = new ArrayList<>();
        scanner= new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nTo-Do List Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Mark Task as Complete");
        System.out.println("3. View Tasks");
        System.out.println("4. Remove Task");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
    }

    public void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter task due date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();

        Task newTask = new Task(title, description, dueDate);
        tasks.add(newTask);
        System.out.println("Task added successfully.");
    }
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nTasks List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ": " + tasks.get(i));
            }
        }
    }

    public void markTaskAsComplete() {
        viewTasks();
        System.out.print("Select task index to mark as complete: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markComplete();
            System.out.println("Task marked as complete.");
        } else {
            System.out.println("Invalid task index. Please try again.");
        }
    }

   

    public void removeTask() {
        viewTasks();
        System.out.print("Select task index to remove: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid task index. Please try again.");
        }
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    markTaskAsComplete();
                    break;
                case 3:
                    viewTasks();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        todoList.run();
    }
}
