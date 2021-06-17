package com.mocadev.taskagile.domain.model.user;

import com.mocadev.taskagile.domain.common.security.PasswordEncryptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-18
 **/
@Component
@RequiredArgsConstructor
public class RegistrationManagement {

	private final UserRepository repository;
	private final PasswordEncryptor passwordEncryptor;

	public User register(String username, String emailAddress, String password)
		throws RegistrationException {
		User existingUser = repository.findByUsername(username);
		if (existingUser != null) {
			throw new UsernameExistsException();
		}

		existingUser = repository.findByEmailAddress(emailAddress.toLowerCase());
		if (existingUser != null) {
			throw new EmailAddressExistsException();
		}

		String encryptedPassword = passwordEncryptor.encrypt(password);
		User newUser = User.create(username, emailAddress.toLowerCase(), encryptedPassword);
		repository.save(newUser);
		return newUser;
	}

}
