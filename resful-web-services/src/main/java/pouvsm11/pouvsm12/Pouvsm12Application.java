package pouvsm11.pouvsm12;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pouvsm11.pouvsm12.entity.HelloWorldBean;
import pouvsm11.pouvsm12.entity.User;
import pouvsm11.pouvsm12.repository.HelloWordBeanRepository;
import pouvsm11.pouvsm12.repository.UserRepository;

import pouvsm11.pouvsm12.service.UserService;

@SpringBootApplication
public class Pouvsm12Application implements CommandLineRunner{
@Autowired
   private UserRepository userRepository;

  @Autowired
     private  HelloWordBeanRepository helloWordBeanRepository;
  
	public static void main(String[] args) {
		SpringApplication.run(Pouvsm12Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
  userRepository.save(new User( "Adam", new Date()));
userRepository.save(new User( "Eve", new Date()));
userRepository.save(new User( "Jack", new Date()));

helloWordBeanRepository.save(new HelloWorldBean( "bonjour coly"));
helloWordBeanRepository.save(new HelloWorldBean( "bonjor thiogane"));
helloWordBeanRepository.save(new HelloWorldBean( "bonjur lrs etudiants "));

    }

}
