package lab4_3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Admin {
    private final RailwayCashBox railwayCashBox;

    public Admin(RailwayCashBox railwayCashBox) {
        this.railwayCashBox = railwayCashBox;
    }

    public void addTrain(
            String dayAndTime,
            Integer number,
            Integer seatsAmount,
            ArrayList<String> stations,
            Float pricePerSeat
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Train train = new Train(
                LocalDateTime.parse(dayAndTime, formatter),
                number,
                seatsAmount,
                stations,
                pricePerSeat
        );
        railwayCashBox.addTrains(train);
    }
}
