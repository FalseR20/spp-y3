package lab6_2;

public class Program {
    /**
     * <a href="https://refactoring.guru/ru/design-patterns/adapter">Adapter pattern</a>
     */

    public static void main(String[] args) {
        var analogClock = new AnalogClock(300, 54);
        var digitalTime = new AnalogClockAdapter(analogClock);
        digitalTime.printTime();
    }
}
