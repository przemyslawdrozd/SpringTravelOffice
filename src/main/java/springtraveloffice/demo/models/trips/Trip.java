package springtraveloffice.demo.models.trips;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class Trip {

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate start;
    private LocalDate end;
    private String destination;
    private int price;

    public Trip(LocalDate start, LocalDate end, String destination, int price) {
        this.start = start;
        this.end = end;
        this.destination = destination;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Destination: " + destination +
                "\nStart: " + start.toString() +
                "\nEnd: " + end.toString() +
                "\nPrice: " + getPrice();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public String getDestination() {
        return destination;
    }
}
