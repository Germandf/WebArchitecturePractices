package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import models.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT t FROM Person t where t.name = :name")
    public List<Person> findAllByName(String name);
	
    @Query("SELECT t FROM Person t where t.years = :years")
    public List<Person> findAllByYears(int years);
    
}
