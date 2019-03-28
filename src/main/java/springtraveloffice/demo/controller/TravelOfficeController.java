package springtraveloffice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springtraveloffice.demo.models.Customer;
import springtraveloffice.demo.models.exceptions.NoSuchCustomerException;
import springtraveloffice.demo.models.exceptions.NoSuchTripException;
import springtraveloffice.demo.models.trips.Trip;
import springtraveloffice.demo.service.TravelOfficeService;

import java.util.*;

@RestController
@EnableSwagger2
public class TravelOfficeController {

    private TravelOfficeService travelOfficeService;

    @Autowired
    public TravelOfficeController(TravelOfficeService travelOfficeService) {
        this.travelOfficeService = travelOfficeService;
    }

    @GetMapping("/getCustomer")
    public Customer getCustomerFromGET(@RequestParam String name) {
        Customer customer = new Customer(name);
        customer.setName(customer.getName().toLowerCase());
        return customer;
    }

    @PostMapping("/addCustomer")
    public Customer getCustomerFromPOST(@RequestBody Customer customer) {
        customer.setName(customer.getName().toUpperCase());
        travelOfficeService.addCustomer(customer);
        return customer;
    }

    @GetMapping("/getTrips")
    public HashMap<String, Trip> getTripFromGET() {
        return travelOfficeService.trips();
    }

    @PostMapping("/addTrip")
    public Trip setTripSET(@RequestBody Trip trip) {
        this.travelOfficeService.addTrip(trip.getDestination(), trip);
        return trip;
    }

    @GetMapping("/trip/{name}")
    public Trip findTripByDestiny(@PathVariable String name) {
        return this.travelOfficeService.findTripByDestiny(name);
    }

    @GetMapping("/customer/{name}")
    public Customer findCustomerByName(@PathVariable("name") String name) throws NoSuchCustomerException {
        return travelOfficeService.findCustomerByName(name);
    }

    @GetMapping("/customers")
    public List<HashSet<Customer>> getCustomers() {
        return Collections.singletonList(travelOfficeService.customerList());
    }

    @DeleteMapping("/remove_customer/{name}")
    public boolean deleteCustomerByName(@PathVariable("name") String name) throws NoSuchCustomerException {
        Customer c = findCustomerByName(name);
        return travelOfficeService.removeCustomer(c);
    }

    @DeleteMapping("/remove_trip/{name}")
    public boolean removeTrip(@PathVariable("name") String name) throws NoSuchTripException {
        return travelOfficeService.removeTrip(name);
    }
}
