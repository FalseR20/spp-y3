package lab6_2;

public class AnalogClock {
    private final Integer hourDegrees;
    private final Integer minuteDegrees;

    AnalogClock(Integer hoursDegrees, Integer minutesDegrees) {
        this.hourDegrees = hoursDegrees;
        this.minuteDegrees = minutesDegrees;
    }

    public Integer getHourDegrees() {
        return hourDegrees;
    }

    public Integer getMinuteDegrees() {
        return minuteDegrees;
    }
}
