import java.util.GregorianCalendar;

public class Time {
    private int timezone;
    private int hours;
    private int minutes;
    private int seconds;

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        if(timezone>=-12 && timezone<=13) this.timezone = timezone;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if(hours>=0 && hours<=23) this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if(minutes>=0 && minutes<=59) this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if(seconds>=0 && seconds<=59) this.seconds = seconds;
    }

    public Time() {
        setTimezone(0);
        setHours(0);
        setMinutes(0);
        setSeconds(0);
    }

    public Time(int timezone, int hours, int minutes, int seconds) {
        setTimezone(timezone);
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public Time(Time t) {
        setTimezone(t.getTimezone());
        setHours(t.getHours());
        setMinutes(t.getMinutes());
        setSeconds(t.getSeconds());
    }

    public void setTime(Time t) {
        setTimezone(t.getTimezone());
        setHours(t.getHours());
        setMinutes(t.getMinutes());
        setSeconds(t.getSeconds());
    }

    public Time getTime() {
        return new Time(this.getTimezone(), this.getHours(), this.getMinutes(), this.getSeconds());
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d TZ:%d", getHours(), getMinutes(), getSeconds(), getTimezone());
    }

    public void setCurrentTime() {
        GregorianCalendar gc1 = new GregorianCalendar();
        this.setHours(gc1.getTime().getHours());
        this.setMinutes(gc1.getTime().getMinutes());
        this.setSeconds(gc1.getTime().getSeconds());
    }

    public void tickSecond() {
        setSeconds(this.getSeconds()+1);
    }

//    public static void main(String[] args) {
//        Time t1 = new Time(-2, 7, 53, 22);
//        Time t2 = new Time(11, 14, 3, 8);
//        t2.tickSecond();
//        Time t3 = new Time(-12, 23, 68, 37); // 68 minutes!!
//        System.out.println(t1);
//        System.out.println(t2);
//        System.out.println(t3);
//
//        Time t4 = new Time();
//        t4.setCurrentTime();
//        System.out.println(t4);
//    }
}
