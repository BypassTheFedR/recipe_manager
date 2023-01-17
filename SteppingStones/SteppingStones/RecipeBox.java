package SteppingStones;

import java.util.ArrayList;
import java.util.Scanner;

public class RecipeBox {
	
	/**
	 * Declare instance variables:
	 * a private ArrayList of the type Recipe named listOfRecipes
	 * 
	 */
    private ArrayList<Recipe> listOfRecipes;

	/**
	 * Add accessor and mutator for listOfRecipes
	 * 
	 */
	public ArrayList<Recipe> getListOfRecipes() {
		return listOfRecipes;
	}

	 public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
		this.listOfRecipes = listOfRecipes;
	}

	/**
	 * Constructors for the RecipeBox()
	 * 
	 */
	 public RecipeBox () {
		this.listOfRecipes = new ArrayList<>();
	 }

	 public RecipeBox(ArrayList<Recipe> listOfRecipes) {
		this.listOfRecipes = listOfRecipes;
	 } 
	
	 /*
	  * Prints recipe details
	  */
	 public void printAllRecipeDetails(String selectedRecipeName) {
		for (int i = 0; i < listOfRecipes.size(); ++i) {
			if (listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName)) {
				listOfRecipes.get(i).printRecipe();
			}
		} 
	}
	/*
	 * Prints the names of all recipes in list of recipes
	 */
	public void printAllRecipeNames() {
		for (Recipe currentRecipe : listOfRecipes) {
			System.out.println(currentRecipe.getRecipeName());
		}
	}

	/*
	 * Adds a new recipe to the RecipeBox
	 */
	public void addNewRecipe() {
		listOfRecipes.add(new Recipe().addNewRecipe());
		
		
		/* 
		* Scanner addScnr = new Scanner(System.in);
		* System.out.println("Enter the name of the recipe: ");
		* listOfRecipes.add(addScnr.nextLine());
		* Recipe tmpRecipe = new Recipe();
		* tmpRecipe.addNewRecipe();
		*/

		// addScnr.close();
	}

	/*
	 * Deletes a recipe from the recipe box.
	 */
	public void deleteRecipe(String recipeToDelete) {
		for (int k = 0; k < listOfRecipes.size(); ++k) {
			if (listOfRecipes.get(k).getRecipeName().equals(recipeToDelete)) {
				listOfRecipes.remove(k);
			}
		}
		// deleteScnr.close();
	}
		
	public void menu() {

		RecipeBox myRecipeBox = new RecipeBox();
        Scanner menuScnr = new Scanner(System.in);
        	
		/**
		* Print a menu for the user to select one of the three options:
		*
		*/
		
		System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete a Recipe\n" + "\nPlease select a menu item:");
        while (menuScnr.hasNextInt() || menuScnr.hasNextLine()) {
            System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete a Recipe\n" + "\nPlease select a menu item:");
            int input = menuScnr.nextInt();
	
            				
			if (input == 1) {
                myRecipeBox.addNewRecipe();
            } else if (input == 2) {
				menuScnr.nextLine();
                System.out.println("Which recipe?\n");
				String selectedRecipeName = menuScnr.nextLine();
				myRecipeBox.printAllRecipeDetails(selectedRecipeName);
            } else if (input == 3) {
				for (int j = 0; j < myRecipeBox.listOfRecipes.size(); ++j) {
					System.out.println((j+1) + ": " + myRecipeBox.listOfRecipes.get(j).getRecipeName());
				}
			} else if (input == 4) {
				menuScnr.nextLine();
                System.out.println("Which recipe?\n");
				String recipeToDelete = menuScnr.nextLine();
				myRecipeBox.deleteRecipe(recipeToDelete);
            } else {
                System.out.println("\nMenu\n" + "1. Add Recipe\n" + "2. Print Recipe\n" + "3. Adjust Recipe Servings\n" + "4. Delete a Recipe\n" + "\nPlease select a menu item:");
            }
					
			System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete a Recipe\n" + "\nPlease select a menu item:");
		}
		// menuScnr.close();
	}
}


/**
 * 
 * Final Project Details:
 * 
 * For your final project submission, you should add a menu item and a method 
 *		to access the custom method you developed for the Recipe class 
 * 		based on the Stepping Stone 5 Lab.
 *
 */