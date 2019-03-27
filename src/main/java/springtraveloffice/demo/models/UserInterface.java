package springtraveloffice.demo.models;

import springtraveloffice.demo.models.trips.Trip;

public interface UserInterface {

    Customer addCustomer();

    Trip addTrip();

    void assign();

    boolean removeCustomer();

    boolean removeTrip();

    void showTrips();

    void showCustomers();
}
