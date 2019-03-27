package springtraveloffice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springtraveloffice.demo.models.Address;
import springtraveloffice.demo.models.Customer;
import springtraveloffice.demo.models.exceptions.NoSuchCustomerException;
import springtraveloffice.demo.models.trips.AbroadTrip;
import springtraveloffice.demo.service.TravelOfficeService;

import java.time.LocalDate;

@RestController
@EnableSwagger2
public class TravelOfficeController {

    @Autowired
    TravelOfficeService travelOfficeService;

    @GetMapping("/addCustomer/{name}")
    public Customer addCustomer(@PathVariable("name") String name) {
        return travelOfficeService.addCustomer(new Customer(name));
    }

    @GetMapping("/getCustomer")
    Customer getCustomerFromGET(@RequestParam String name) {
        Customer customer = new Customer(name);
        customer.setName(customer.getName().toLowerCase());
        return customer;
    }

    @PostMapping("/addCustomer")
    Customer getCustomerFromPOST(@RequestBody Customer customer) {
        customer.setName(customer.getName().toUpperCase());
        return customer;
    }

    @GetMapping("/getTrip")
    AbroadTrip getAbroadTripGET(@RequestParam String destination,
                                @RequestParam LocalDate start,
                                @RequestParam LocalDate end,
                                @RequestParam int insurance,
                                @RequestParam int price) {
        AbroadTrip abroadTrip = new AbroadTrip(start, end, destination, insurance, price);
        return abroadTrip;
    }

    @PostMapping("/addTrip")
    AbroadTrip setAbroadTripSET(@RequestParam AbroadTrip abroadTrip) {
        this.travelOfficeService.addTrip(abroadTrip.getDestination(), abroadTrip);
        return abroadTrip;
    }



//    @GetMapping("/")
//    Address getAddressFromGET(@RequestParam String street,
//                              @RequestParam String zip,
//                              @RequestParam String city) {
//        Address address = new Address(street, zip, city);
//        return address;
//    }
//
//    @PostMapping("/")
//    Address getAddressFromPOST(@RequestBody Address address) {
//        address.setStreet(address.getStreet().toLowerCase());
//        address.setZip(address.getZip().toLowerCase());
//        address.setCity(address.getCity());
//        return address;
//    }

    @GetMapping("/customer/{name}")
    public Customer findCustomerByName(@PathVariable("name") String name) throws NoSuchCustomerException {
        return travelOfficeService.findCustomerByName(name);
    }

    @GetMapping("/customers")
    public String getCustomerCount() {
        return travelOfficeService.getCustomerCount();
    }
}
