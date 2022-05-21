import java.util.Scanner;

public class mainATM {
    public static void main(String[] args) {
        AtmMachine atm = new AtmMachine();
        atm.add_new_account("ahmed,1234,123,10000");
        atm.add_new_account("adham,12345,123,10000");
        atm.add_new_account("amr,12345678,123,10000");
        atm.add_new_account("omar,123456789,123,10000");
        atm.add_new_account("mohammed,1234567891,123,10000");
        atm.add_new_account("abdulraof,12345678912,123,10000");
        atm.add_new_account("abdulrahman,1234567,123,10000");
        atm.add_new_account("osama,123456789123,123,10000");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Card Number:");
        String card_num = scan.nextLine();
        atm.insert_card(card_num);
        atm.print_info();
        System.out.println("\nEnter Amount to Deposit:");
        double ammount = Double.parseDouble(scan.nextLine());
        atm.deposit(ammount);
        atm.print_info();
        System.out.println("\nEnter Amount to Withdraw:");
        ammount = Double.parseDouble(scan.nextLine());
        atm.withdraw(ammount);
        atm.print_info();
        System.out.println("\nRetrieving Card......\n");
        atm.retrieve_card();
        atm.print_info();
    }
}
