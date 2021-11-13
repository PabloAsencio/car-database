package de.pabloasencio.carddatabase;

import de.pabloasencio.carddatabase.domain.Car;
import de.pabloasencio.carddatabase.domain.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class CardatabaseApplication {

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	private CarRepository carRepository;

	public CardatabaseApplication(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2107, BigDecimal.valueOf(59000)));
			carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, BigDecimal.valueOf(29000)));
			carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, BigDecimal.valueOf(39000)));
		};
	}

}
