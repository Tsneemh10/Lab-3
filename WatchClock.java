public class WatchClock {
    String state = "NORMAL";
    String ActState = "TIME";
    int min = 37;
    int hour = 11;
    int day = 5;
    int month = 5;
    int year = 2022;
    boolean alarm = false;

    public void BtnPress(String option){
        switch (this.state) {
            case "NORMAL":
                if (this.ActState.equals("TIME") && option.equals("a")) this.ActState = "DATE";
                else if (this.ActState.equals("DATE") && option.equals("a")) this.ActState = "TIME";
                else if (option.equals("b")) {
                    this.ActState = "ALARM";
                    this.state = "ALARM";
                } else if (option.equals("c")) {
                    this.ActState = "MIN";
                    this.state = "UPDATE";
                } else return;
                break;
            case "UPDATE":
                if (option.equals("d")) {
                    this.ActState = "TIME";
                    this.state = "NORMAL";
                } else if (this.ActState.equals("MIN")) {
                    if (option.equals("a")) this.ActState = "HOUR";
                    else if (option.equals("b")) {
                        if (this.min == 59) this.min = 0;
                        else this.min++;
                    }
                } else if (this.ActState.equals("HOUR")) {
                    if (option.equals("a")) this.ActState = "DAY";
                    else if (option.equals("b")) {
                        if (this.hour == 12) this.hour = 1;
                        else this.hour++;
                    }
                } else if (this.ActState.equals("DAY")) {
                    if (option.equals("a")) this.ActState = "MONTH";
                    else if (option.equals("b")) {
                        if (this.day == 30) this.day = 1;
                        else this.day++;
                    }
                } else if (this.ActState.equals("MONTH")) {
                    if (option.equals("a")) this.ActState = "YEAR";
                    else if (option.equals("b")) {
                        if (this.month == 12) this.month = 1;
                        else this.month++;
                    }
                } else if (this.ActState.equals("YEAR")) {
                    if (option.equals("a")) {
                        this.ActState = "TIME";
                        this.state = "NORMAL";
                    } else if (option.equals("b")) {
                        this.year++;
                    }
                } else return;
                break;
            case "ALARM":
                if (option.equals("a") && this.ActState.equals("ALARM")) {
                    this.ActState = "CHIME";
                    this.alarm = true;
                }
                else if (option.equals("d")) {
                    this.ActState = "TIME";
                    this.state = "NORMAL";
                } else return;
                break;
        }
    }

    public void GetData(){
        System.out.println("Current Display: "+this.state);
        System.out.println("Current State: "+this.ActState);
        String time = "";
        if (Integer.toString(this.hour).length() != 2) time+= "0" + Integer.toString(this.hour);
        else time+= Integer.toString(this.hour);
        time+=":";
        if (Integer.toString(this.min).length() != 2) time+= "0" + Integer.toString(this.min);
        else time+= Integer.toString(this.min);
        System.out.println(time);
        String date = Integer.toString(this.day) + "/" + Integer.toString(this.month) + "/" + Integer.toString(this.year);
        System.out.println(date);
    }
}
