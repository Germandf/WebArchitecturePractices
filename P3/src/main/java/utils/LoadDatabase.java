package utils;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;
import models.Address;
import models.Person;
import repositories.PersonRepository;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(@Qualifier("personRepository") PersonRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Person(1, 1, "German", new Address(1, "Ayacucho 324", "Tres Arroyos"))));
        };
    }
}