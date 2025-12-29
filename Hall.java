/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelsystem;

/**
 *
 * @author noort
 */
public class Hall extends Accommodation {

    private int capacity;
    private String type;
    private boolean hasBuffet;

    public Hall(String RoomNumber, double pricePerDay,boolean Available, int capacity, String type, boolean hasBuffet  ) {
       
        super(RoomNumber, pricePerDay,Available);
        this.capacity = capacity;
        this.type = type;
        this.hasBuffet = hasBuffet;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasBuffet() {
        return hasBuffet;
    }

    public void setHasBuffet(boolean hasBuffet) {
        this.hasBuffet = hasBuffet;
    }

    @Override
    public String toString() {
        return "Hall Information:\n" +
                "Hall Number: " + getRoomNumber() + "\n" +
                "Price per Day: " + getPricePerNight() + " SAR\n" +
                "Capacity: " + capacity + " People\n" +
                "Type: " + type + "\n" +
                "Buffet Included: " + (hasBuffet ? "Yes" : "No");
    }
     @Override
    public void showAmenities() {
        System.out.println(" WiFi ,mini bar ,decor");
}

 @Override
    public int NumOfBeds() {
        // halls are not beds-based — return 0 or some sentinel
        return 0;
}}


