/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelsystem;

/**
 *
 * @author noort
 */

    abstract class Accommodation{
    private String RoomNumber;
    private static int numOFUnits;
    private double pricePerNight;
    private boolean Available;

    public Accommodation(String RoomNumber, double pricePerNight, boolean Available) {
        this.RoomNumber = RoomNumber;
        this.pricePerNight = pricePerNight;
        this.Available = Available;
    }

    public Accommodation() {
        this("", 0.0, true);
    }

    public void setRoomNumber(String RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public static void setNumOFUnits(int numOFUnits) {
        Accommodation.numOFUnits = numOFUnits;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setAvailable(boolean Available) {
        this.Available = Available;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public static int getNumOFUnits() {
        return numOFUnits;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return Available;
    }
    public abstract int NumOfBeds();
    public abstract void showAmenities();

    @Override
    public String toString() {
        return "Accommodation{" + "RoomNumber=" + RoomNumber + ", pricePerNight=" + pricePerNight + ", Available=" + Available + '}';
    }
}

