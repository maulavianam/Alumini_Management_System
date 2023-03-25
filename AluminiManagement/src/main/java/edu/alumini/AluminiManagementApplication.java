package edu.alumini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.alumini.entity.Alumini;
import edu.alumini.repository.AluminiRepository;

@SpringBootApplication
public class AluminiManagementApplication implements CommandLineRunner
{
	@Autowired
	private AluminiRepository aluminiRepository;

	public static void main(String[] args) 
	{
		SpringApplication.run(AluminiManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		Alumini a1 = Alumini.builder().name("Anam").phone("8901234565").email("an@gamil.com").year("2021").address("Nigdi").build();
		Alumini a2 = Alumini.builder().name("Raha").phone("7896543212").email("ra@gamil.com").year("2022").address("Pimpri").build();
		Alumini a3 = Alumini.builder().name("Taimoor").phone("9087654321").email("tai@gamil.com").year("2020").address("Akurdi").build();
		Alumini a4 = Alumini.builder().name("Vamika").phone("8769056453").email("vam@gamil.com").year("2022").address("Ravet").build();
		Alumini a5 = Alumini.builder().name("Vayu").phone("7654903215").email("va@gamil.com").year("2023").address("Nigdi").build();

		
		aluminiRepository.save(a1);
		aluminiRepository.save(a2);
		aluminiRepository.save(a3);
		aluminiRepository.save(a4);
		aluminiRepository.save(a5);
	}

}
