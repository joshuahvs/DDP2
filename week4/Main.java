public class Main{
    public static void main(String[] args) {
        Time t1 = new Time();
        Time t2 = new Time(1, 25, 30.0);
        Time t3 = new Time(2, 25, 30.0);
        System.out.println(t1 == t2);
        System.out.println(t1.equals(t2));
        System.out.println(t1 == t3);
        System.out.println(t1.equals(t3));
    }
}

class Time {
    private int hour;
    private int minute;
    private double second;

    Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0.0;
    }

    Time(int hour, int minute, double second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public String toString() {
        return
        String.format("%02d:%02d:%04.1f",
        this.hour, this.minute,
        this.second);
    }

    public boolean equals(Time that) {
        return this.hour == that.hour
        && this.minute == that.minute
        && this.second == that.second;
    }

    public int getHour(){
        return this.hour;
    }

    public int getMinute(){
        return this.minute;
    }

    public double getSecond(){
        return this.second;
    }

    public void setHour(int hour){
        this.hour = hour;
    }

    public void setMinute (int minute){
        this.minute = minute;
    }

    public void setSecond (double second){
        this.second = second;
    }
}
