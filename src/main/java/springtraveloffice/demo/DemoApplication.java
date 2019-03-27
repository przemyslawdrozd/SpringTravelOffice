package springtraveloffice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springtraveloffice.demo.models.MainHandler;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

//    private static void showMenu() {
//        MainHandler mainHandler = new MainHandler();
//        String choice = scanner.next();
//
//        while (!choice.equals("8")) {
//            switch (choice) {
//                case "1":
//                    mainHandler.addCustomer();
//                    break;
//                case "2":
//                    mainHandler.addTrip();
//                    break;
//                case "3":
//                    mainHandler.assign();
//                    break;
//                case "4":
//                    mainHandler.removeCustomer();
//                    break;
//                case "5":
//                    mainHandler.removeTrip();
//                    break;
//                case "6":
//                    mainHandler.showCustomers();
//                    break;
//                case "7":
//                    mainHandler.showTrips();
//                    break;
//            }
//            System.out.println("Next action: ");
//            choice = scanner.next();
//        }
//        System.out.println("Exit!");
//    }

}
