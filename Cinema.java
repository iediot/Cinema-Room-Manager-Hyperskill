package cinema;

public class Cinema {

    public static void cinemaShower(String[][] matrix, int rows, int lines) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i < lines; i++)
            System.out.print(i + " ");
        System.out.println(lines + " ");
        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " ");
            for (int j = 1; j < lines; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println(matrix[i][lines]);
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int option, exit = 0, purchasedTickets = 0, currentIncome = 0, totalIncome = 0, ticketPrice = 0;
        float percentage = 0;
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int lines = scanner.nextInt();
        System.out.println(" ");
        String[][] matrix = new String[rows + 1][lines + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= lines; j++) {
                matrix[i][j] = "S";
            }
        }
        while (exit != 1) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            option = scanner.nextInt();
            System.out.println(" ");
            switch (option) {
                case 1:
                    cinemaShower(matrix, rows, lines);
                    break;
                case 2:
                    while (true) {
                        System.out.println("Enter a row number:");
                        int rowSelected = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int lineSelected = scanner.nextInt();
                        if (rowSelected > rows || lineSelected > lines) {
                            System.out.println("Wrong input!");
                            System.out.println(" ");
                            continue;
                        }
                        if (matrix[rowSelected][lineSelected].equals("B")) {
                            System.out.println("That ticket has already been purchased!");
                            System.out.println(" ");
                        } else {
                            matrix[rowSelected][lineSelected] = "B";
                            ticketPrice = rows * lines <= 60 ? 10 :
                                    rowSelected > rows / 2 ? 8 : 10;
                            break;
                        }
                    }
                    purchasedTickets++;
                    currentIncome += ticketPrice;
                    System.out.println("Ticket price: $" + ticketPrice);
                    System.out.println(" ");
                    break;
                case 3:
                    if (purchasedTickets > 0)
                        percentage = (float)(purchasedTickets) / (float)(rows * lines) * 100;
                    totalIncome = rows * lines <= 60 ? rows * lines * 10 :
                            ((rows / 2) * 10 + (rows - rows / 2) * 8) * lines;
                    System.out.println("Number of purchased tickets: " + purchasedTickets);
                    System.out.printf("Percentage: %.2f%%%n", percentage);
                    System.out.println("Current income: $" + currentIncome);
                    System.out.println("Total income: $" + totalIncome);
                    System.out.println(" ");
                    break;
                case 0:
                    exit = 1;
                    break;
            }
        }
    }
}