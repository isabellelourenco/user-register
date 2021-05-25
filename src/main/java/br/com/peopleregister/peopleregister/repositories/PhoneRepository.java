package br.com.peopleregister.peopleregister.repositories;

import br.com.peopleregister.peopleregister.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long>{
}
