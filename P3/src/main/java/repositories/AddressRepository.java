package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
