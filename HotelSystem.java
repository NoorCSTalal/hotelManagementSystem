/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelsystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelSystem {
  
    static ArrayList<Accommodation> list = new ArrayList<>();
    static ArrayList<Reservation> reservelist = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice = 0;
        fillList(list); 
        System.out.println("***** WELCOME TO  WAN HOTEI MANAGEMENT SYSTEM *****");
        do {
            try {
                menu();
                choice = input.nextInt();
                switch (choice) {
                    case 1: //new  Accommodation
                        add(list);
                        break;

                    case 2://Remove accommodation

                        remove();
                        break;
                    case 3:
                        //Display Accommodation
                        for (Accommodation accommodation : list) {
                            System.out.println(accommodation);
                            System.out.printf("Reservation Price Per Day: %.2f SAR.\n", accommodation.getPricePerNight());

                            System.out.print("Amenities:");
                            accommodation.showAmenities();
                            //downcasting to call a specific methods
                            if (accommodation instanceof SUITE) {
                                ((SUITE) accommodation).PartyType();
                            }
                            System.out.println("***************************************************");
                        }
                        System.out.println("Total Accommodation: " + Accommodation.getNumOFUnits());//calling static method
                        break;

                    case 4:  //restraunt
                        System.out.println(" Welcome to the Hotel Restaurant! ");
                        Restraunt restaurant = new Restraunt("Grand Hotel Restaurant", 3);

                        Meal breakfast = new Meal("Breakfast", 8.0);
                        Meal lunch = new Meal("Lunch", 12.0);
                        Meal dinner = new Meal("Dinner", 18.0);

                        restaurant.addMeal(breakfast, 0);
                        restaurant.addMeal(lunch, 1);
                        restaurant.addMeal(dinner, 2);

                        System.out.println("Please choose a meal type:");
                        System.out.println("1. Breakfast");
                        System.out.println("2. Lunch");
                        System.out.println("3. Dinner");
                        System.out.print("Enter your choice (1-3): ");

                        int mealChoice = input.nextInt();
                        Meal selectedMeal = null;

                        switch (mealChoice) {
                            case 1:
                                System.out.println("\nYou chose Breakfast!");
                                breakfast.showBreakfastMenu();
                                selectedMeal = breakfast;
                                break;
                            case 2:
                                System.out.println("\nYou chose Lunch!");
                                lunch.showLunchMenu();
                                selectedMeal = lunch;
                                break;
                            case 3:
                                System.out.println("\nYou chose Dinner!");
                                dinner.showDinnerMenu();
                                selectedMeal = dinner;
                                break;
                            default:
                                System.out.println(" Invalid choice.");
                                break;
                        }
                        if (selectedMeal != null) {
                            System.out.print("\nEnter the dish number you want: ");
                            int dishNumber = input.nextInt();//0 ,1, 2

                            double dishPrice = selectedMeal.getDishPrice(dishNumber);
                            selectedMeal.setPrice(dishPrice);

                            System.out.println("\nYou selected: " + selectedMeal.getMealType());
                            System.out.println("Dish Price: SAR" + dishPrice);

                            restaurant.calculateBill();
                        } //end switch into 7

                        System.out.println("\nReturning to main menu...\n");
                        break; //end case 7

                    case 5: //GUI
                        //GUI.main(null); //calling static method
                        //  public static void main(String[] args) {
                        HotelGUI.main(null);

                        break;

                    case 6: //Read from text file

                        ReadText rt = new ReadText();
                        rt.openTextFile("subscription.txt");
                        rt.readFromFile();
                        rt.closeFile();
                        break;

                    case 7://Save/Write to text file
                        WriteText wf = new WriteText();
                        wf.openTextFile("subscription.txt");
                        if (list.isEmpty()) {
                            System.out.println("No subscription yet.");
                        } else {
                            for (Accommodation ele : list) {
                                wf.writeToFile(ele);
                            }
                        }
                        wf.closeFile();
                        System.out.println("All subscriptions saved to the text file subscription.txt");
                        break;

                    case 8://Upgrade Room to Suite

                        Scanner input7 = new Scanner(System.in);
                        System.out.print("Enter room number to upgrade: ");
                        String roomNum = input7.nextLine();

                        Accommodation target = null;

                        for (Accommodation a : list) {

                            
                            if (a.getRoomNumber().trim().equalsIgnoreCase(roomNum.trim())) {
                                target = a;
                                break;
                            }
                        }

                        if (target == null) {
                            System.out.println("Room not found!");
                            continue; 
                        }

                        if (target instanceof Room) {

                           
                            String msg = ((Room) target).UpgradeToSuite();
                            System.out.println(msg);

                           
                            String newSuiteNumber = "S" + (list.size() + 200);

                           
                            SUITE newSuite = new SUITE(
                                    newSuiteNumber,
                                    target.getPricePerNight() + 300,
                                    true,
                                    2,
                                    3
                            );

                            
                            int index = list.indexOf(target);
                            list.set(index, newSuite);

                            System.out.println("Room upgraded successfully!");
                            System.out.println("New Suite Number: " + newSuiteNumber);
                            System.out.println("--------------------------------");

                            continue;  
                        } else {
                            System.out.println("This type cannot be upgraded!");
                        }
                        break;

                    case 9: //Exit
                        System.out.println("Thank you for using our system.\nHave a nice day.");
                        break;
                    default:
                        System.out.println("Invalid Choice!");

                } //end switch 

            } catch (InputMismatchException ex) {
                System.out.println("Invalid input");
                input.nextLine();
            } catch (NullPointerException ex) {
                System.out.println(ex);
            } catch (ClassCastException ex) {
                System.out.println(ex);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println(ex);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } while (choice != 9); //end of do
    }

//end of main 
    //---------------------------------------------------------- out of main
    //menu methood*
    public static void menu() {

        System.out.print("\n1. New Accommodation.\n"
                + "2. Remove Accommodation.\n"
                + "3. Display Accommodation.\n"
                + "4. Restaurant Reservation.\n"
                + "5. GUI.\n"
                + "6. Read From File.\n"
                + "7. Save Accommodations.\n"
                + "8.Upgrade Room to Suite \n"
                + "9. Exit.\n"
                + ">> ");

    }

    //add method  used caase 1:
    public static void add(ArrayList<Accommodation> list) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Hotel Booking System!");
        System.out.println("Please select the type of booking you want:");
        System.out.println("1. Suite");
        System.out.println("2. Single Room");
        System.out.println("3. Double Room");
        System.out.println("4. Hall");
        System.out.print("Enter your choice: ");
        int type = input.nextInt();

        Accommodation accommodation = null;
        String roomNumber = "R" + (list.size() + 100); 
        double price = 0;

        switch (type) {
            case 1:
                System.out.print("Enter number of rooms in the suite: ");
                int numRooms = input.nextInt();
                System.out.print("Enter number of guests: ");
                int numGuests = input.nextInt();

                price = 500 + (numRooms * 200) + (numGuests * 100);
                accommodation = new SUITE(roomNumber, price, true, numRooms, numGuests);
                break;

            case 2:
                System.out.print("Do you want a desk? (true/false): ");
                boolean hasDesk = input.nextBoolean();
                price = hasDesk ? 350 : 300;
                accommodation = new SingleRoom(roomNumber, price, true, hasDesk);
                break;

            case 3:
                System.out.print("Enter bed type (King/Queen): ");
                String bedType = input.next();

                System.out.print("Enter number of guests: ");
                int guests = input.nextInt();

                price = bedType.equalsIgnoreCase("King") ? 400 : 350;
                price += (guests > 2) ? 100 : 0;
                accommodation = new DoubleRoom(roomNumber, price, true, bedType);
                break;

            case 4:
                System.out.print("Enter hall type (Wedding/Conference/Party): ");
                input.nextLine(); 
                String hallType = input.nextLine();

                System.out.print("Enter hall capacity: ");
                int capacity = input.nextInt();

                System.out.print("Do you want buffet service? (true/false): ");
                boolean hasBuffet = input.nextBoolean();

              
                price = 1500 + (capacity * 10);
                if (hasBuffet) {
                    price += 500;
                }
                if (hallType.equalsIgnoreCase("Wedding")) {
                    price += 1000;
                }
//  public Hall(String RoomNumber, double pricePerDay,boolean Available, int capacity, String type, boolean hasBuffet  ) {
                accommodation = new Hall(roomNumber, price, true, capacity, hallType, hasBuffet);
                break;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        list.add(accommodation);

        
        System.out.print("Enter guest name: ");
        input.nextLine(); 
        String guestName = input.nextLine();

        System.out.print("Enter guest number: ");
        int guestNum = input.nextInt();

        System.out.print("Enter number of nights: ");
        int numnight = input.nextInt();

       
        Guest guest = new Guest(guestName, guestNum);

        
        Reservation reservation = new Reservation(1, numnight, "Pending", accommodation, guest);
        reservelist.add(reservation);

        
        System.out.println("\n Booking completed successfully!");
        System.out.println("----------------------------");
        System.out.println("Reservation ID: " + reservation.getRESERVATION_ID());
        System.out.println("Guest Name: " + guest.getGuestName());
        System.out.println("Room number: " + roomNumber);
        System.out.println("Type: " + accommodation.getClass().getSimpleName());
        System.out.println("Price per night/day: " + price + " SAR");
        System.out.println("Total (with tax): " + reservation.calculateBill() + " SAR");
        System.out.println("----------------------------");
    }

    // remove methood*
    public static void remove() {
        System.out.print("Enter Room Number to remove: ");
        String roomNumber = input.next();
        boolean removed = false;

        for (int i = 0; i < list.size(); i++) {
            Accommodation room = list.get(i);
            if (room.getRoomNumber().equalsIgnoreCase(roomNumber)) {
                list.remove(i);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Accommodation with room number " + roomNumber + " has been removed.");
        } else {
            System.out.println("No accommodation with room number " + roomNumber + " found.");
        }
    }

    // methood fillist*
    public static void fillList(ArrayList<Accommodation> list) {
        list.add(new SUITE("AS105", 1200.0, true, 4, 5));
        list.add(new SUITE("BG413", 975.0, true, 3, 4));

        list.add(new SingleRoom(" Standard Single Room ", 299.0, true, true));
        list.add(new DoubleRoom(" Deluxe Double Room ", 500.0, true, "One King Size Bed"));

        
        //  public Hall(String RoomNumber, double pricePerDay,boolean Available, int capacity, String type, boolean hasBuffet  ) {
        list.add(new Hall("H301", 2500.0, true, 150, "Wedding", true));
        list.add(new Hall("H302", 1800.0, true, 80, "Conference", false));
    }

}


