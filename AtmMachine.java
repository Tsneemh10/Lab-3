import java.util.Scanner;

public class AtmMachine {
    String accounts[] = new String[1000];
    double min_withdraw_value = 15000;
    int acc_index = 0;
    int curr_index = 0;
    String curr_card = "";
    String curr_name = "";
    String curr_pin = "";
    double curr_money = 0;
    public void insert_card(String card_num){
        for(int i=0;i<this.accounts.length;i++){
            int first = -1, second = -1, third = -1;
            String curr_acc = this.accounts[i];
            for(int j=0;j<curr_acc.length();j++){
                if(curr_acc.charAt(j) == ','){
                    if(first == -1) first = j;
                    else if (second == -1) second = j;
                    else third = j;
                }
            }
            if(card_num.equals(curr_acc.substring(first+1,second))){
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter Pin:");
                String pin = scan.nextLine();
                if(!pin.equals(curr_acc.substring(second+1,third))){
                    System.out.println("Incorrect Pin!\n");
                    break;
                }
                this.curr_name = curr_acc.substring(0,first);
                this.curr_card = curr_acc.substring(first+1,second);
                this.curr_pin = curr_acc.substring(second+1,third);
                this.curr_money = Double.parseDouble(curr_acc.substring(third+1));
                this.curr_index = i;
                break;
            }
        }
    }
    public void retrieve_card(){
        this.accounts[this.curr_index] = this.curr_name+","+this.curr_card+","+this.curr_pin+","+Double.toString(this.curr_money);
        this.curr_card = "";
        this.curr_name = "";
        this.curr_pin = "";
        this.curr_money = 0;
    }
    public void deposit(double ammount){
        this.curr_money += ammount;
    }
    public void withdraw(double ammount){
        this.curr_money -= ammount;
    }
    public void print_info(){
        System.out.println(String.format("Card Holder Name: %s",this.curr_name));
        System.out.println(String.format("Card Number: %s",this.curr_card ));
        System.out.println(String.format("Card Pin: %s",this.curr_pin ));
        System.out.println(String.format("Funds: %.2f", this.curr_money));
    }
    public void add_new_account(String acc){
        this.accounts[this.acc_index] = acc;
        this.acc_index++;

    }
}
