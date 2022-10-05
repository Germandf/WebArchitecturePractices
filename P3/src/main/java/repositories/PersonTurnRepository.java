package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.PersonTurn;

public interface PersonTurnRepository extends JpaRepository<PersonTurn, Integer> {

}
