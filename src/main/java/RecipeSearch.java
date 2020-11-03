
import java.util.Scanner;

public class RecipeSearch {

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        RecipeManager manager = new RecipeManager();
        TextUI ui = new TextUI(scanner, manager);
        
        ui.start();
        
    }
}
