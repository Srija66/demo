
package com.example.demo;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.web.bind.annotation.GetMapping;
		import org.springframework.web.bind.annotation.RequestParam;
		import org.springframework.web.bind.annotation.RestController;
		import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
		import java.time.LocalTime;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		LocalTime time=LocalTime.now();
		String greeting;
		if (time.isBefore(LocalTime.NOON)) {
			greeting = "Good morning";
		} else if (time.isBefore(LocalTime.of(18, 0))) {
			greeting = "Good afternoon";
		} else {
			greeting = "Good evening";
		}
		return String.format("Hello %s, %s!", name, greeting);
	}
}
