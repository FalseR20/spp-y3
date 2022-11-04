package lab4_3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Passenger {

    public Request createRequest(String destination, String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Request request = new Request();
        request.setDayAndTime(LocalDateTime.parse(date, formatter));
        request.setDestination(destination);
        return request;
    }

    public Ticket chooseTrain(ArrayList<Train> trains) {
        Scanner scanner = new Scanner(System.in);
        for (Train train : trains) {
            System.out.println(train);
        }
        while (true) {
            System.out.println("Choose a train number: ");
            Integer chosenNumber = scanner.nextInt();
            for (Train train : trains) {
                if (train.getNumber().equals(chosenNumber)) {
                    train.reserveSeat();
                    Ticket ticket = new Ticket();
                    ticket.setPrice(train.getPricePerSeat());
                    ticket.setSeatNumber(train.getOccupiedSeatsAmount());
                    return ticket;
                }
            }
        }
    }
}
