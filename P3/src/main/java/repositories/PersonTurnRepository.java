package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.PersonTurn;

public interface PersonTurnRepository extends JpaRepository<PersonTurn, Integer> {

}
