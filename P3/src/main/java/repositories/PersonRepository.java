package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
