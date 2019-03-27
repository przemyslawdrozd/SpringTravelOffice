package springtraveloffice.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import springtraveloffice.demo.service.TravelOfficeService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @MockBean
    private MockMvc mockMvc;

    @Autowired
    private TravelOfficeService travelOfficeService;

    @Test
    public void returnCustomers() throws Exception {
        this.mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(content().string(travelOfficeService.getCustomerCount()));
    }

}
