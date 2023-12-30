package EmployeService.Employe;

import EmployeService.Employe.entities.Employe;
import EmployeService.Employe.repository.EmployeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class EmployeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (EmployeRepository employeRepository){

		return args -> {
			Employe employe = Employe.builder()
					.name("Mehdi")
					.brithDate(LocalDate.of(1992,07,20))
					.hiringDate(LocalDate.of(2020,05,15))
					.solde(10f)
					.build();
			employeRepository.save(employe);

			Employe employe1 = Employe.builder()
					.name("Hamza")
					.brithDate(LocalDate.of(1992,07,20))
					.hiringDate(LocalDate.of(2020,05,15))
					.solde(15f)
					.build();
			employeRepository.save(employe1);
		};
	}
}
