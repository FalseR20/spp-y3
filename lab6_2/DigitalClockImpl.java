package lab6_2;

public class DigitalClockImpl implements DigitalClock {
    private final Integer hours;
    private final Integer minutes;

    DigitalClockImpl(Integer hours, Integer minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public void printTime() {
        System.out.printf("Текущее время: %02d:%02d", hours, minutes);
    }
}
