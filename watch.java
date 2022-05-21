import java.util.Scanner;

public class mainWatch {
    public static void main(String[] args) {
        WatchClock w = new WatchClock();
        w.GetData();
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter Option: ");
        String curr_op = scan.nextLine();
        while (!curr_op.equals("stopplz")){
            w.BtnPress(curr_op);
            w.GetData();
            System.out.println("\nEnter Option: ");
            curr_op = scan.nextLine();
        }
    }
}
