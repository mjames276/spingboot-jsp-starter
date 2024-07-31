package uk.co.digitalpenguin.xrp.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import uk.co.digitalpenguin.xrp.models.User;

public interface UserRepository extends CrudRepository<User, Integer> 
{

	@Query(value = "SELECT * FROM users where email = :username", nativeQuery=true)
	User findByUsername(String username);

}
