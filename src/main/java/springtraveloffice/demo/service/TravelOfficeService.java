package springtraveloffice.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import springtraveloffice.demo.models.Address;
import springtraveloffice.demo.models.Customer;
import springtraveloffice.demo.models.MainHandler;
import springtraveloffice.demo.models.TravelOffice;
import springtraveloffice.demo.models.exceptions.NoSuchCustomerException;
import springtraveloffice.demo.models.trips.Trip;

@Service
public class TravelOfficeService {

    @Autowired
    private TravelOffice travelOffice;

    public void addTrip(String tripName, Trip trip) {
        travelOffice.addTrip(tripName, trip);
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

    public Address addAddress(Address address){
        return travelOffice.addAddress(address);
    }

}
