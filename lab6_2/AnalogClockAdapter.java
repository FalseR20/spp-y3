package lab6_2;

public class AnalogClockAdapter implements DigitalClock {
    private final AnalogClock analogClock;

    AnalogClockAdapter(AnalogClock analogClock) {
        this.analogClock = analogClock;
    }

    @Override
    public void printTime() {
        if (analogClock.getHourDegrees() >= 30 && analogClock.getMinuteDegrees() != 360) {
            DigitalClock digitalClock = new DigitalClockImpl(
                    analogClock.getHourDegrees() / 30,
                    analogClock.getMinuteDegrees() / 6
            );
            digitalClock.printTime();
        } else if (analogClock.getMinuteDegrees() == 360) {
            DigitalClock digitalClock = new DigitalClockImpl(
                    analogClock.getHourDegrees() / 30 + 1,
                    0
            );
            digitalClock.printTime();
        } else {
            DigitalClock digitalClock = new DigitalClockImpl(
                    12,
                    analogClock.getMinuteDegrees() / 6
            );
            digitalClock.printTime();
        }
    }
}
