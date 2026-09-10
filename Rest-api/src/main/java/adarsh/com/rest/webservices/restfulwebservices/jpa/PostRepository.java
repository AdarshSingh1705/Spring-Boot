package adarsh.com.rest.webservices.restfulwebservices.jpa;

import adarsh.com.rest.webservices.restfulwebservices.User.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {



}
