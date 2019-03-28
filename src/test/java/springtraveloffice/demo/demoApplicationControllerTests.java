package springtraveloffice.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import springtraveloffice.demo.controller.TravelOfficeController;
import springtraveloffice.demo.models.Customer;
import springtraveloffice.demo.models.exceptions.NoSuchCustomerException;
import springtraveloffice.demo.service.TravelOfficeService;

import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class demoApplicationControllerTests {

    @InjectMocks
    private TravelOfficeController controller;

    @Mock
    private TravelOfficeService service;

    private Customer customer;
    private HashSet<Customer> customers;

    @Before
    public void setup() throws NoSuchCustomerException {
        controller = new TravelOfficeController(service);

        customers = new HashSet<>();
        customer = new Customer("Tim");
        customers.add(customer);

//        when(travelOfficeService.addCustomer(customer)).thenReturn(customer);
        when(service.findCustomerByName("Tim")).thenReturn(customer);
        when(service.addCustomer(customer)).thenReturn(customer);
    }

    @Test
    public void findCustomerByName() throws NoSuchCustomerException {
        assertEquals(new ResponseEntity<>(customer, HttpStatus.OK), controller.findCustomerByName("Tim"));
    }

    @Test
    public void addCustomer() {
        assertEquals(new ResponseEntity<>(customer, HttpStatus.OK), controller.getCustomerFromPOST(customer));
    }
}
