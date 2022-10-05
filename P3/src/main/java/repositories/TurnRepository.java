package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Turn;

public interface TurnRepository extends JpaRepository<Turn, Integer> {

}
