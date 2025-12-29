/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelsystem;

/**
 *
 * @author noort
 */
public class Restraunt implements Payable  {
 

    private String restaurantName; 
    private Meal[] meals;              

    
    public Restraunt(String restaurantName, int numberOfMeals) {
        this.restaurantName = restaurantName;
        this.meals = new Meal[numberOfMeals];
    }

    
    public void addMeal(Meal meal, int index) {
        if (index >= 0 && index < meals.length) {
            meals[index] = meal;
        }
    }

    
    public void displayMenu() {
        System.out.println( restaurantName + " Menu:");
        for (Meal meal : meals) {
            if (meal != null) {
                System.out.println("- " + meal.getMealType() + " | Price: SAR" + meal.getPrice());
            }
        }
    }

    @Override
    public double calculateBill() {
        double total = 0;

        for (Meal meal : meals) {
            if (meal != null)
                total += meal.getPrice();
        }

        double tax = total * 0.15;
        double finalBill = total + tax;

    System.out.println("Subtotal: SAR" + total);
    System.out.println("Tax: " + String.format("%.2f", tax));
    System.out.println("Total Bill: SAR" + finalBill);

        return finalBill;
    }

    @Override
    public String toString() {
        String result = "Restaurant Name: " + restaurantName + "\nMenu:\n";
        for (Meal meal : meals) {
            if (meal != null) {
                result += "- " + meal.toString() + "\n";
            }
        }
        return result;
    }
}


