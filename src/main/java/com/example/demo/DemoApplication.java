
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
	private AtomicInteger counter = new AtomicInteger(0);
	@GetMapping("/hello")
	public Map<String, Object> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		LocalTime time=LocalTime.now();
		String greeting;
		if (time.isBefore(LocalTime.NOON)) {
			greeting = "Good morning";
		} else if (time.isBefore(LocalTime.of(18, 0))) {
			greeting = "Good afternoon";
		} else {
			greeting = "Good evening";
		}
		int visit=counter.incrementAndGet();

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("greeting", greeting);
		response.put("name", name);
		response.put("visitorNumber", visit);
		return response;
	}
}
