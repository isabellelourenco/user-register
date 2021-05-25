package br.com.peopleregister.peopleregister.repositories;

import br.com.peopleregister.peopleregister.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
