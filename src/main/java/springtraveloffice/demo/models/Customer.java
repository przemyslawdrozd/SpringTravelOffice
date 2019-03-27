package springtraveloffice.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import springtraveloffice.demo.models.trips.Trip;

@Setter
@Getter
@AllArgsConstructor
public class Customer {

    private String name;
    private Address address;
    private Trip trip;

    public Customer(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void assignTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                address.toString() + "\n" +
                trip.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Trip getTrip() {
        return trip;
    }
}
