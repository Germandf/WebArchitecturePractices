package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Integer> {

}
