package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Integer> {

}
