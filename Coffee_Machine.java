import java.util.Scanner;

public class CoffeeMachine {
    int stock = 1000;
    double coffee_price = 10.0;
    double curr_money = 0;
    public void insert_money(double money){
        curr_money = money;
        System.out.println(String.format("You Have Inserted %.2f$", curr_money));
    }
    public void brew_coffee(){
        if(curr_money>=coffee_price){
            System.out.println("Brewing Please Wait.....\n");
            System.out.println("Done!");
            System.out.println(String.format("Here is your change %.2f$", curr_money-coffee_price));
            curr_money = 0;
        }
    }
}
