package com.mocadev.taskagile.web.api;

import com.mocadev.taskagile.domain.application.commands.RegistrationCommand;
import com.mocadev.taskagile.domain.model.user.RegistrationException;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-16
 **/
public interface UserService {
	void register(RegistrationCommand commmand) throws RegistrationException;
}
