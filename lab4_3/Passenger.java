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
        System.out.println("Choose a train number: ");
        Integer chosenNumber = scanner.nextInt();
        boolean trainIsNotFound = true;
        Train chosenTrain = null;
        for (int i = 0; i < trains.size() && trainIsNotFound; i++) {
            if (trains.get(i).getNumber().equals(chosenNumber)) {
                chosenTrain = trains.get(i);
                chosenTrain.reserveSeat();
                trainIsNotFound = false;
            }
        }
        if (chosenTrain != null) {
            Ticket ticket = new Ticket();
            ticket.setPrice(chosenTrain.getPricePerSeat());
            ticket.setSeatNumber(chosenTrain.getOccupiedSeatsAmount());
            return ticket;
        } else {
            throw new RuntimeException("Train is not found!");
        }
    }
}
