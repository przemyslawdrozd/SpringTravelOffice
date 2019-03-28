package springtraveloffice.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import springtraveloffice.demo.controller.TravelOfficeController;
import springtraveloffice.demo.service.TravelOfficeService;

@RunWith(SpringRunner.class)
public class DemoApplicationServiceTests {

    private TravelOfficeController controller;

    private TravelOfficeService travelOfficeService;

    @Before
    public void setup() {
        controller = new TravelOfficeController(travelOfficeService);


    }

}
