package CodeAlpha;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hotel Reservation Menu ---");
            System.out.println("1. Search Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Reservations");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter room category (Standard/Deluxe/Suite): ");
                    String cat = sc.nextLine();
                    system.searchAvailableRooms(cat);
                    break;
                case 2:
                    System.out.print("Enter guest name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter room number: ");
                    int roomNum = sc.nextInt();
                    System.out.print("Enter payment amount: ");
                    double pay = sc.nextDouble();
                    system.makeReservation(name, roomNum, pay);
                    break;
                case 3:
                    System.out.print("Enter reservation ID to cancel: ");
                    int resId = sc.nextInt();
                    system.cancelReservation(resId);
                    break;
                case 4:
                    system.viewReservations();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
