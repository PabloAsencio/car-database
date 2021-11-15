package de.pabloasencio.carddatabase;

import de.pabloasencio.carddatabase.domain.*;
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

	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;
	private final UserRepository userRepository;

	public CardatabaseApplication(CarRepository carRepository, OwnerRepository ownerRepository, UserRepository userRepository) {
		this.carRepository = carRepository;
		this.ownerRepository = ownerRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Owner ownerOne = new Owner("John", "Johnson");
			Owner ownerTwo = new Owner("Mary", "Robinson");
			ownerRepository.save(ownerOne);
			ownerRepository.save(ownerTwo);

			carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2107, BigDecimal.valueOf(59000), ownerOne));
			carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, BigDecimal.valueOf(29000), ownerTwo));
			carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, BigDecimal.valueOf(39000), ownerTwo));

			userRepository.save(new User("user",
					"$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
					"USER"));
			userRepository.save(new User("admin",
					"$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
					"ADMIN"));
		};
	}

}
