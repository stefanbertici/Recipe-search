
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeManager {
    ArrayList<String> fileData;
    ArrayList<Recipe> recipes;
    
    public RecipeManager() {
        this.fileData = new ArrayList<>();
        this.recipes = new ArrayList<>();
    }
    
    //we read the specified file
    public void readFile(String input) {
        try(Scanner fileScanner = new Scanner(Paths.get(input))) {
            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                //if we encounter an empty line, we create the recipe object
                //we then clear fileData so it can be used for next recipe
                if (line.isEmpty()) {
                    this.createRecipe(this.fileData, this.recipes);
                    continue;
                }
                
                this.fileData.add(line);
            }
            //when we reach end of file our while loop exits one step early
            //so we use the remaining data in fileData to create the last recipe
            this.createRecipe(this.fileData, this.recipes);
        }
        
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    //we use data from fileData to create the recipe
    public void createRecipe(ArrayList<String> fileData, ArrayList<Recipe> recipes) {
        ArrayList<String> ingredients = new ArrayList<>();
        String recipeName = fileData.get(0); 
        int cookingTime = Integer.valueOf(fileData.get(1));
        for (int i = 2; i < fileData.size(); i ++) {
            ingredients.add(fileData.get(i));
        }
            
        recipes.add(new Recipe(recipeName, cookingTime, ingredients));
        fileData.clear();
    }
    
    public void print() {
        System.out.println("Recipes: ");
        for (Recipe recipe : this.recipes) {
            System.out.println(recipe.toString());
        }
    }
    
    public void printByName(String searchFor) {
        System.out.println("Recipes: ");
        for (Recipe recipe : this.recipes) {
            if (recipe.getName().contains(searchFor)) {
                System.out.println(recipe.toString());
            }
        }
    }
    
    public void printByCookingTime(int maxTime) {
        System.out.println("Recipes: ");
        for (Recipe recipe : this.recipes) {
            if (recipe.getCookingTime() <= maxTime) {
                System.out.println(recipe.toString());
            }
        }
    }
    
    public void printByIngredient(String searchFor) {
        ArrayList<String> ingredients = new ArrayList<>();
        System.out.println("Recipes: ");
        for (Recipe recipe : this.recipes) {
            ingredients = recipe.getIngredients();
            for (String ingredient : ingredients) {
                if (ingredient.equals(searchFor)) {
                    System.out.println(recipe.toString());
                }
            }
        }
    }
}

