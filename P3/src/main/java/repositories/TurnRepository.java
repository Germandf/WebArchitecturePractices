package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Turn;

public interface TurnRepository extends JpaRepository<Turn, Integer> {

}
