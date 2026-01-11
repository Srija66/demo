
package com.example.demo;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.web.bind.annotation.GetMapping;
		import org.springframework.web.bind.annotation.RequestParam;
		import org.springframework.web.bind.annotation.RestController;
		import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
		import java.time.LocalTime;
		import java.util.HashMap;
		import java.util.LinkedHashMap;
		import java.util.Map;
		import java.util.concurrent.atomic.AtomicInteger;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
