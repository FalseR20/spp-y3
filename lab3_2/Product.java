package lab3_2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Product {
    public int id;
    public String name;
    public int upc;
    public String producer;
    public float price;
    public Calendar expirationDate;

    Product(int id, String name, int upc, String producer, float price, int storageMonthDelta) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.producer = producer;
        this.price = price;
        expirationDate = new GregorianCalendar();
        expirationDate.clear(Calendar.MILLISECOND);
        expirationDate.clear(Calendar.SECOND);
        expirationDate.clear(Calendar.MINUTE);
        expirationDate.clear(Calendar.HOUR);
        expirationDate.add(Calendar.MONTH, storageMonthDelta);
    }

    Product(int id, String name, int upc, String producer, float price, int storageMonthDelta, int storageDaysDelta) {
        this(id, name, upc, producer, price, storageMonthDelta);
        expirationDate.add(Calendar.DATE, storageDaysDelta);
    }

    boolean is_expired() {
        return expirationDate.before(GregorianCalendar.getInstance());
    }

    @Override
    public String toString() {
        return String.format("%s(%s - %s | %s BYN%s)", this.getClass().getSimpleName(), producer, name, price, is_expired() ? " | expired" : "");
    }
}
