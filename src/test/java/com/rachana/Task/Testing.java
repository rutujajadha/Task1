package com.rachana.Task;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.rachana.Task.model.User;
import com.rachana.Task.repository.UserRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class Testing{
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("rucha11@gmail.com");
		user.setFirstName("Rucha1");
		user.setLastName("Andhale1");
		user.setPassword("rucha1234");
		
		User savedUser = repo.save(user);
		
		User existUser = entityManager.find(User.class, savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}
	
	/*
	 * @Test public void testFindUserByEmail() { String email = "rucha@gmail.com";
	 * 
	 * User user = repo.findByEmail(email);
	 * 
	 * assertThat(user).isNotNull(); }
	 */
}

