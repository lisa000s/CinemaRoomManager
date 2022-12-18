package cinema;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
public class Cinema {
    public static int ticketPrice = 0;
    public static int curIncome = 0;
    public static float totIncome = 0;
    public static int purchasedTickets = 0;
    public static float percentage = 0;
    public static void main(String[] args) {
        System.out.print("Enter the number of rows:\n");
        Scanner scanner = new Scanner(System.in);
        int nrow = scanner.nextInt();
        System.out.print("Enter the number of seats in each row:\n");
        int nseat = scanner.nextInt();
        int rowNumber = 0;
        int seatNumber = 0;
        int menu = -1;
        ticketPrice = getTicketPrice(nrow, nseat, rowNumber);
        int totIncome = 0;
        if (nrow * nseat <= 60) {
            totIncome = nrow * nseat * 10;
        }
        else if (nrow % 2 == 0) {
            totIncome = (((nseat / 2) * 10) * nrow) + (((nseat / 2) * 8) * nrow);
        }
        else {
            totIncome = (((nseat / 2) * 10) * nrow) + ((((nseat / 2)+ 1) * 8) * nrow);
        }
        String[][]seatsTaken = new String[nrow+1][nseat+1];
        System.out.println();
        while (menu != 0) {
            System.out.println(
                    """
                            1. Show the seats
                            2. Buy a ticket
                            3. Statistics
                            0. Exit""");
            menu = scanner.nextInt();
            System.out.println();
            switch (menu) {

                case 1:
                    showSeats(nrow, nseat, rowNumber, seatNumber, seatsTaken);
                    break;
                case 2:

                    buyTicket(nrow, nseat, seatsTaken);

                    break;


                case 3:
                   System.out.println("\nNumber of purchased tickets: " + purchasedTickets);
                   System.out.printf("Percentage: %.2f", percentage);
                   System.out.print("%\n");
                   System.out.println("Current income: $" + curIncome);
                   System.out.println("Total income: $" + totIncome);
                   break;
            }
            System.out.println();
        }
    }

    private static void showSeats(int nrow, int nseat, int rowNumber, int seatNumber, String[][]seatsTaken) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= nseat; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int j = 1; j <= nrow; j++) {
            System.out.print(j);
            for (int k = 1; k <= nseat; k++) {
                if (Objects.equals(seatsTaken[j][k], "B")) {
                    System.out.print(" B");
                } else {
                    System.out.print(" S");
                }
            }
            System.out.println();
        }
    }
    public static int getTicketPrice (int nrow, int nseat, int rowNumber) {
        if (nrow * nseat <= 60) {
            ticketPrice = 10;
        }
        else if (nrow % 2 == 0) {
            if (rowNumber > 0 && rowNumber < 5) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        }
        else {
            if (rowNumber > 0 && rowNumber < 5) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        }
        return ticketPrice;
    }
    private static void buyTicket(int nrow, int nseat,  String[][] seatsTaken) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a row number:\n");
        int rowNumber = scanner.nextInt();
        System.out.print("Enter a seat number in that row:\n");
        int seatNumber = scanner.nextInt();
        if (rowNumber > nrow || seatNumber > nseat) {
            System.out.println("\nWrong input!\n");
            buyTicket(nrow, nseat, seatsTaken);
        } else if (Objects.equals(seatsTaken[rowNumber][seatNumber], "B")) {
            System.out.println("\nThat ticket has already been purchased!\n");
            buyTicket(nrow,nseat, seatsTaken);
        } else {
            seatsTaken[rowNumber][seatNumber] = "B";
            System.out.println();
            purchasedTickets++;
            curIncome += getTicketPrice(nrow, nseat, rowNumber);
            percentage = (purchasedTickets / (float)(nrow * nseat)) * 100;
            System.out.println("Ticket price: $" + ticketPrice);
        }
    }
}