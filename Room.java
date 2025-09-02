package CodeAlpha;
import java.io.Serializable;

public class Room implements Serializable {
    private int roomNumber;
    private String category;
    private boolean isBooked;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getCategory() { return category; }
    public boolean isBooked() { return isBooked; }

    public void bookRoom() { this.isBooked = true; }
    public void cancelBooking() { this.isBooked = false; }

    @Override
    public String toString() {
        return "Room " + roomNumber + " [" + category + "] - " +
               (isBooked ? "Booked" : "Available");
    }
}
