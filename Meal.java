/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelsystem;

  
  public class Meal {
    private String mealType;
    private double price;

    // القوائم
    private String[] breakfastMenu = {"1. Pancakes - 8 SAR", "2. Omelette - 10 SAR", "3. Waffles - 9 SAR"};
    private double[] breakfastPrices = {8, 10, 9};

    private String[] lunchMenu = {"1. Grilled Chicken - 12 SAR", "2. Pasta - 10 SAR", "3. Caesar Salad - 9 SAR"};
    private double[] lunchPrices = {12, 10, 9};

    private String[] dinnerMenu = {"1. Steak - 18 SAR", "2. Salmon - 20 SAR", "3. Soup - 7 SAR"};
    private double[] dinnerPrices = {18, 20, 7};

    public Meal(String mealType, double price) {
        this.mealType = mealType;
        this.price = price;
    }

    public String getMealType() {
        return mealType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    // عرض القوائم
    public void showBreakfastMenu() {
        System.out.println("\n🍳 Breakfast Menu:");
        for (String item : breakfastMenu)
            System.out.println(item);
    }

    public void showLunchMenu() {
        System.out.println("\n🍔 Lunch Menu:");
        for (String item : lunchMenu)
            System.out.println(item);
    }

    public void showDinnerMenu() {
        System.out.println("\n🍝 Dinner Menu:");
        for (String item : dinnerMenu)
            System.out.println(item);
    }

    // ميثود ترجع السعر حسب اختيار المستخدم
    public double getDishPrice(int choice) {
        switch (mealType.toLowerCase()) {
            case "breakfast":
                return breakfastPrices[choice - 1];
            case "lunch":
                return lunchPrices[choice - 1];
            case "dinner":
                return dinnerPrices[choice - 1];
            default:
                return 0;
        }
    }

    // toString
    @Override
    public String toString() {
        return "Meal Type: " + mealType + ", Price: SAR" + price;
    }
}

   
   