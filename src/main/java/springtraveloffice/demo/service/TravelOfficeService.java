package springtraveloffice.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtraveloffice.demo.models.Customer;
import springtraveloffice.demo.models.TravelOffice;
import springtraveloffice.demo.models.exceptions.NoSuchCustomerException;
import springtraveloffice.demo.models.exceptions.NoSuchTripException;
import springtraveloffice.demo.models.trips.Trip;

import java.util.HashMap;
import java.util.HashSet;

@Service
public class TravelOfficeService {

    @Autowired
    private TravelOffice travelOffice;

    public Trip addTrip(String tripName, Trip trip) {
        return travelOffice.addTrip(tripName, trip);
    }

    public Customer addCustomer(Customer customer){
        return travelOffice.addCustomer(customer);
    }

    public Customer findCustomerByName(String name) throws NoSuchCustomerException {
        return travelOffice.findCustomerByName(name);
    }

    public String getCustomerCount(){
        return travelOffice.getCustomerCount();
    }

    public boolean removeCustomer(Customer customer) throws NoSuchCustomerException {
        return travelOffice.removeCustomer(customer);
    }

    public boolean removeTrip(String tripName) throws NoSuchTripException {
        return travelOffice.removeTrip(tripName);
    }

    public HashSet<Customer> customerList() {
        return travelOffice.getCustomers();
    }

    public HashMap<String, Trip> trips () {
        return travelOffice.getTrips();
    }

    public Trip findTripByDestiny(String name) {
         return travelOffice.findTripByDestiny(name);
    }
}
