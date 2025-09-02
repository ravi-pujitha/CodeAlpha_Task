package CodeAlpha;

import java.io.*;
import java.util.*;

public class HotelReservationSystem {
    private List<Room> rooms = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private static final String FILE_ROOMS = "rooms.dat";
    private static final String FILE_RESERVATIONS = "reservations.dat";

    public HotelReservationSystem() {
        loadData();
    }

    // Add rooms
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Search available rooms
    public void searchAvailableRooms(String category) {
        System.out.println("Available " + category + " Rooms:");
        for (Room r : rooms) {
            if (r.getCategory().equalsIgnoreCase(category) && !r.isBooked()) {
                System.out.println(r);
            }
        }
    }

    // Make reservation
    public void makeReservation(String guestName, int roomNumber, double payment) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber && !r.isBooked()) {
                r.bookRoom();
                Reservation res = new Reservation(reservations.size() + 1, guestName, r, payment);
                reservations.add(res);
                System.out.println("Booking Successful: " + res);
                saveData();
                return;
            }
        }
        System.out.println("Room not available!");
    }

    // Cancel reservation
    public void cancelReservation(int reservationId) {
        for (Reservation res : reservations) {
            if (res.getReservationId() == reservationId) {
                res.getRoom().cancelBooking();
                reservations.remove(res);
                System.out.println("Reservation Cancelled: " + reservationId);
                saveData();
                return;
            }
        }
        System.out.println("Reservation not found!");
    }

    // View all reservations
    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        for (Reservation res : reservations) {
            System.out.println(res);
        }
    }

    // Save and Load Data
    private void saveData() {
        try (ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream(FILE_ROOMS));
             ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream(FILE_RESERVATIONS))) {
            out1.writeObject(rooms);
            out2.writeObject(reservations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadData() {
        try (ObjectInputStream in1 = new ObjectInputStream(new FileInputStream(FILE_ROOMS));
             ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(FILE_RESERVATIONS))) {
            rooms = (List<Room>) in1.readObject();
            reservations = (List<Reservation>) in2.readObject();
        } catch (Exception e) {
            // No data yet, initialize default rooms
            rooms = new ArrayList<>();
            reservations = new ArrayList<>();
            rooms.add(new Room(101, "Standard"));
            rooms.add(new Room(102, "Deluxe"));
            rooms.add(new Room(103, "Suite"));
        }
    }
}
