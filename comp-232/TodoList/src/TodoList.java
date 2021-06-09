import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    // Used to keep track of the items on the list
    public static ArrayList<String> todoList = new ArrayList<>();

    // This function manages the main menu of the program. Users can input commands to access other submenus which will send them to other functions in this program
    public static void mainMenu() {
        System.out.println();
        System.out.println("-- Main Menu --");
        System.out.println("You can add tasks to your list (type \"add\"), see all added tasks (type \"see\"), clear all items on your list (type \"clear\"), or stop the program (type \"stop\").");
        Scanner input = new Scanner(System.in);
        String command = input.next();
        while(!command.equalsIgnoreCase("add") && !command.equalsIgnoreCase("see") && !command.equalsIgnoreCase("clear") && !command.equalsIgnoreCase("stop")) {
            System.out.println("Invalid input. You may only enter \"add\", \"see\", \"clear\", or \"stop\".");
            command = input.next();
        }
        command = command.toLowerCase();
        switch(command) {
            case "add": addTasks();
                break;
            case "see": seeTasks();
                break;
            case "clear": clearTasks();
                break;
            case "stop": stopProgram();
                break;
        }
    }

    // Allows users to add tasks to their list. This function will run until the user types "back" in order to return to the main menu
    public static void addTasks() {
        System.out.println();
        System.out.println("-- Add Tasks --");
        System.out.println("Enter a task to add to your list or type \"back\" to go back to the main menu.");
        Scanner input = new Scanner(System.in);
        String task = input.nextLine();
        while(!task.equalsIgnoreCase("back")) {
            todoList.add(task);
            System.out.println("Added \"" + task + "\" to your todo list...");
            System.out.println();
            System.out.println("Enter another task to add to your list or type \"back\" to go back to the main menu.");
            task = input.nextLine();
        }
        mainMenu();
    }

    // Displays the tasks that they have on their list or tells them if the list is empty
    public static void seeTasks() {
            System.out.println();
            System.out.println("-- Your Todo List --");
            if(todoList.isEmpty()) {
                System.out.println("** Your list is empty. Type \"add\" to begin adding tasks. **");
            } else {
                for(String task : todoList) {
                    System.out.println(task);
                }
            }
        mainMenu();
    }

    // Removes all tasks from the list or tells users if their list is empty and has nothing to clear
    public static void clearTasks() {
        System.out.println();
        if(todoList.isEmpty()) {
            System.out.println("Your todo list is already empty.");
        } else {
            System.out.println("Clearing your todo list...");
            todoList.clear();
        }
        System.out.println("Sending you back to the main menu...");
        mainMenu();
    }

    // Provides and ending message when the user wants to stop the program and exits the program
    public static void stopProgram() {
        System.out.println();
        System.out.println("Ending todo list program...");
        System.exit(0);
    }

    // Only used upon first start of the program to print a welcome message and take users to the main menu
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to your todo list!");
        mainMenu();
    }
}
