package lab4_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        RailwayCashBox railwayCashBox = new RailwayCashBox();
        Admin admin = new Admin(railwayCashBox);
        admin.addTrain(
                "2019-10-21 14:00",
                701,
                500,
                new ArrayList<>(Arrays.asList("Жабинка", "Берёза", "Барановичи", "Минск")),
                13.50f);
        admin.addTrain(
                "2019-10-21 14:00",
                703,
                500,
                new ArrayList<>(Arrays.asList("Барановичи", "Минск")),
                15.50f);
        Passenger passenger = new Passenger();
        Request request = passenger.createRequest("Барановичи", "2019-10-21 14:00");
        Ticket ticket = passenger.chooseTrain(railwayCashBox.findTrainsByRequest(request));
        System.out.println(ticket);
    }
}
