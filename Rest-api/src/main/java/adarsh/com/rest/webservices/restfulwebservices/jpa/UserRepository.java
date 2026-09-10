package adarsh.com.rest.webservices.restfulwebservices.jpa;

import adarsh.com.rest.webservices.restfulwebservices.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {



}
