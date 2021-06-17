package com.mocadev.taskagile.domain.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-18
 **/
@Repository
public interface  UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	User findByEmailAddress(String emailAddress);

}
