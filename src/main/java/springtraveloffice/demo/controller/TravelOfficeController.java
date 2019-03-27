package springtraveloffice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springtraveloffice.demo.models.Address;
import springtraveloffice.demo.models.Customer;
import springtraveloffice.demo.models.exceptions.NoSuchCustomerException;
import springtraveloffice.demo.service.TravelOfficeService;

@RestController
@EnableSwagger2
public class TravelOfficeController {

    @Autowired
    TravelOfficeService travelOfficeService;

    @GetMapping("/addCustomer/{name}")
    public Customer addCustomer(@PathVariable("name") String name) {
        return travelOfficeService.addCustomer(new Customer(name));
    }


    @GetMapping("/customer/{name}")
    public Customer findCustomerByName(@PathVariable("name") String name) throws NoSuchCustomerException {
        return travelOfficeService.findCustomerByName(name);
    }

    @GetMapping("/customers")
    public String getCustomerCount() {
        return travelOfficeService.getCustomerCount();
    }
}
