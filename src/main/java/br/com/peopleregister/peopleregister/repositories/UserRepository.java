package br.com.peopleregister.peopleregister.repositories;

import br.com.peopleregister.peopleregister.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
