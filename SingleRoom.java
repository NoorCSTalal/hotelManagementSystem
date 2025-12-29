/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelsystem;

/**
 *
 * @author noort
 */
public class SingleRoom extends Room{
    private boolean hasDesk;

    
    public SingleRoom(String roomNumber, double pricePerNight, boolean available, boolean hasDesk) {
        super(roomNumber, pricePerNight, available);
        this.hasDesk = hasDesk;
    }
    
    public SingleRoom() {
        super();
        this.hasDesk = false; //احط ترو؟
    }

    public boolean isHasDesk() {
        return hasDesk;
    }

    public void setHasDesk(boolean hasDesk) {
        this.hasDesk = hasDesk;
    }
    
    @Override
       public String UpgradeToSuite() {
        return "Single room upgraded successfully!";
    }

    @Override
    public int NumOfBeds() {
        return 1;
    }
    @Override //اغير العباره? 
    public String RoomService() {
        return "Single room service: breakfast delivery and daily cleaning.";
    }
    @Override 
    public String toString() {
        return "SingleRoom{ " +
                "RoomNumber ='" + getRoomNumber() + '\'' +
                ", PricePerNight =" + getPricePerNight() +
                ", Available =" + isAvailable() +
                ", HasDesk =" + hasDesk +
                '}';
    }

    @Override
    public void showAmenities() {
        System.out.println("Desk and Wi-Fi");
    }
    
    }