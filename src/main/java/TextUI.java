
import java.util.Scanner;

public class TextUI {
    Scanner scanner;
    RecipeManager manager;
    
    public TextUI(Scanner scanner, RecipeManager manager) {
        this.scanner = scanner;
        this.manager = manager;
    }
    
    public void start() {
        System.out.print("File to read: ");
        String input = scanner.nextLine();
        //we read the specified file
        manager.readFile(input);
        System.out.println("");
        //print, read and execute commands
        System.out.println("Commands:\n" 
                + "list - lists the recipes\n"
                + "stop - stops the program\n" 
                + "find name - searches recipes by name\n"
                + "find cooking time - searches recipes by cooking time\n"
                + "find ingredient - searches recipes by ingredient");
        while (true) {
            System.out.println("");
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }
            
            if (command.equals("list")) {
                System.out.println("");
                manager.print();
            }
            
            if (command.equals("find name")) {
                System.out.print("Searched word: ");
                String searchFor = scanner.nextLine();
                System.out.println("");
                manager.printByName(searchFor);
            }
            
            if (command.equals("find cooking time")) {
                System.out.print("Max cooking time: ");
                int maxTime = Integer.valueOf(scanner.nextLine());
                System.out.println("");
                manager.printByCookingTime(maxTime);
            }
            
            if (command.equals("find ingredient")) {
                System.out.print("Ingredient: ");
                String searchFor = scanner.nextLine();
                System.out.println("");
                manager.printByIngredient(searchFor);
            }
        }
    }
}
