package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
