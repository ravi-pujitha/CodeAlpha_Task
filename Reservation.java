package CodeAlpha;

import java.io.Serializable;

public class Reservation implements Serializable {
    private int reservationId;
    private String guestName;
    private Room room;
    private double payment;

    public Reservation(int reservationId, String guestName, Room room, double payment) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.room = room;
        this.payment = payment;
    }

    public int getReservationId() { return reservationId; }
    public Room getRoom() { return room; }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId +
               ", Guest: " + guestName +
               ", Room: " + room.getRoomNumber() +
               ", Payment: $" + payment;
    }
}
