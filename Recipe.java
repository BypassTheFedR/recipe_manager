package SteppingStones;

import java.util.Scanner;
import java.util.ArrayList;

public class Recipe {
    /*
     * Initialize variables for the class;
     */
    private String recipeName;
    private int servings;
    private ArrayList<String> recipeIngredients = new ArrayList<>();
    private double totalRecipeCalories;
    
    public String getRecipeName() { // Get recipeName
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName; // Sets recipeName for this object.
    }

    public int getServings() { // Get servings
        return servings;
    }

    public void setServings(int servings) {// Sets servings
        this.servings = servings;
    }

    public Ingredient getRecipeIngredients() { // Get recipe ingredients
        return recipeIngredients;    
    }

    public void setRecipeIngredients(ArrayList<String> recipeIngredients) { // Sets the recipe ingredients
        this.recipeIngredients = recipeIngredients;


        /*
         * For help later:
         * https://stackoverflow.com/questions/33060592/getters-and-setters-for-arraylists-in-java 
         */
    }

    public double getTotalRecipeCalories() { // Gets the total recipe calories
        return totalRecipeCalories;
    }

    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }

    /*
     * Constructor methods
     */
    public Recipe() {
        recipeName = "";
        servings = 0;
        recipeIngredients = new ArrayList<>();
        totalRecipeCalories = 0.0; 
    }
    
    public Recipe(String recipeName, int servings, ArrayList<String> recipeIngredients, double totalRecipeCalories) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories; 
    }

    public void printRecipe() {
        double singleServingCalories = (totalRecipeCalories / servings);
        System.out.println("Recipe: " + getRecipeName());
        System.out.println("Serves: " + getServings());
        System.out.println("Ingredients: ");
        for (int i = 0; i < recipeIngredients.size(); ++i) {
            System.out.print(recipeIngredients.get(i) + ", ");
        }
        System.out.print(".");
        System.out.println("Each serving has " + singleServingCalories + " Calories.");
        System.out.println(); // print a blank line for readability
    }

    public Recipe addNewRecipe() {
        boolean addMoreIngredients = true;
        double ingredientAmount = 0.0;
        double totalCalories = 0;
        int numberCaloriesPerUnit = 0;
        String unitMeasurement = "";


        ArrayList<String> recipeIngredients = new ArrayList<>();
        Scanner scnr = new Scanner(System.in);

        System.out.println("What is the name of your recipe?");
        setRecipeName(scnr.nextLine()); // get user input for the recipe name

        System.out.println("How many servings does your recipe make?");
        setServings(scnr.nextInt());
        scnr.nextLine();
        // setServings(Integer.parseInt(scnr.nextLine())); // get user input for the number of servings
        
        do {
            
            System.out.println("What is the name of the next ingredient? (type end if done adding ingredients)"); // Asks the user for nameOfIngredient
            String nameOfIngredient = scnr.nextLine();


            if (nameOfIngredient.toLowerCase().equals("end")) {
                addMoreIngredients = false;
            } else {
                Ingredient tempIngredient = new Ingredient();
                tempIngredient.setNameOfIngredient(nameOfIngredient);
                recipeIngredients.add(nameOfIngredient);
              

                System.out.println("Please enter the amount of the ingredient to be used: "); // Asks the user for the amount of the ingredient and stores it in ingredientAmount
                ingredientAmount = scnr.nextDouble();
                tempIngredient.setIngredientAmount(ingredientAmount);

                System.out.println("Please enter the unit of measurement (e.g. cup, oz. etc.): ");
                unitMeasurement = scnr.next();
                tempIngredient.setUnitMeasurement(unitMeasurement);

                System.out.println("Please enter the number of calories per unit of measurement: ");
                numberCaloriesPerUnit = scnr.nextInt();
                tempIngredient.setNumberCaloriesPerUnit(numberCaloriesPerUnit);
                scnr.nextLine();

                tempIngredient.calculateTotalCalories();
                totalCalories = totalCalories + tempIngredient.getIngredientCalories();
                setTotalRecipeCalories(totalCalories);
                System.out.println("The recipe uses " + ingredientAmount + " " + unitMeasurement + " of " + nameOfIngredient + " and has " + tempIngredient.getIngredientCalories() + " calories.");

            }

        } while (addMoreIngredients); 

        Recipe newRecipe = new Recipe(recipeName, servings, recipeIngredients, totalRecipeCalories);
        return newRecipe;
    }
    /* 
    public Recipe addNewRecipe(){
        Scanner scnr = new Scanner(System.in);
        Ingredient tempIngredient = new Ingredient();
        
        System.out.println("What is the name of your recipe?");
        setRecipeName(scnr.nextLine()); // get user input for the recipe name

        System.out.println("How many servings does your recipe make?");
        setServings(scnr.nextInt()); // get user input for the number of servings
        // System.out.println(); // clears the '\n' after nextInt
        
        tempIngredient.enterNewIngredient();
        setTotalRecipeCalories(tempIngredient.getTotalRecipeCalories());

        Recipe newRecipe = new Recipe(recipeName, servings, recipeIngredients, totalRecipeCalories);
        System.out.println(); // Print a blank line for readability.
        return newRecipe;
    }
    */
}