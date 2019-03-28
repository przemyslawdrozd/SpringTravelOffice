package springtraveloffice.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import springtraveloffice.demo.models.Customer;
import springtraveloffice.demo.models.trips.AbroadTrip;
import springtraveloffice.demo.service.TravelOfficeService;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TravelOfficeService travelOfficeService;

    @Test
    public void returnCustomersTest() throws Exception {

        when(travelOfficeService.getCustomerCount())
                .thenReturn("Amount of Customers: " + 0);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/customers")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

//        System.out.println(mvcResult.getResponse());
        verify(travelOfficeService).getCustomerCount();
    }

    @Test
    public void findCustomerByNameTest() throws Exception {

        Customer customer = new Customer("Tom");
        travelOfficeService.addCustomer(customer);

        when(travelOfficeService.findCustomerByName("Tom"))
                .thenReturn(customer);

        mockMvc.perform(MockMvcRequestBuilders.get("/customer/Tom")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        verify(travelOfficeService).findCustomerByName("Tom");
    }

    @Test
    public void addCustomerTest() throws Exception {
        Customer customer = new Customer("Tom");
        travelOfficeService.addCustomer(customer);

        when(travelOfficeService.addCustomer(customer))
                .thenReturn(customer);

        mockMvc.perform(MockMvcRequestBuilders.get("/addCustomer")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        verify(travelOfficeService).addCustomer(customer);
    }

    @Test
    public void addTripTest() throws Exception {

        LocalDate localDate = LocalDate.of(2000, 10, 10);
        AbroadTrip trip = new AbroadTrip(localDate, localDate, "Italy", 200, 1500);
        String dest = trip.getDestination();
        travelOfficeService.addTrip(dest, trip);

        when(travelOfficeService.addTrip(dest, trip))
                .thenReturn(trip);

        mockMvc.perform(MockMvcRequestBuilders.get("/addTrip")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        verify(travelOfficeService).addTrip(dest, trip);
    }
}

