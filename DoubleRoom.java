/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelsystem;

/**
 *
 * @author noort
 */
    public class DoubleRoom extends Room {
    private String bedType;
    
     public DoubleRoom(String roomNumber, double pricePerNight, boolean available, String bedType) {
        super(roomNumber, pricePerNight, available);
        this.bedType = bedType;
    }
     
     public DoubleRoom() {
        super();
        this.bedType = "Queen"; //او كينغ؟
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }
     
      @Override
    public String UpgradeToSuite() {
        return "Upgraded to Suite with premium amenities!";
    }
    
    @Override
    public int NumOfBeds() {
        return 2;
    }
    
    @Override
    public String RoomService() {
        return "Double room service: mini-bar restocking and room cleaning.";
    }
    
     @Override
    public String toString() {
        return "DoubleRoom{ " +
                "RoomNumber ='" + getRoomNumber() + '\'' +
                ", PricePerNight =" + getPricePerNight() +
                ", Available =" + isAvailable() +
                ", BedType ='" + bedType + '\'' +
                '}';
    }

    @Override
    public void showAmenities() {
        System.out.println(" Wi-Fi , Mini Bar ,Extra Bed");

    }
}