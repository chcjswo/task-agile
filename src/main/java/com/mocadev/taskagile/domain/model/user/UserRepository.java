package com.mocadev.taskagile.domain.model.user;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-18
 **/
public interface  UserRepository {

	/**
	 * Find user by a username
	 *
	 * @param username the provided username used for finding user
	 * @return an instance of <code>User</code> if found, null otherwise
	 */
	User findByUsername(String username);

	/**
	 * Find user by an email address
	 *
	 * @param emailAddress the provided email address used for finding user
	 * @return an instance of <code>User</code> if found, null otherwise
	 */
	User findByEmailAddress(String emailAddress);

	/**
	 * Save a new user or an existing user
	 *
	 * @param user the user instance to be saved
	 * @return the newly save user
	 */
	void save(User user);

}
