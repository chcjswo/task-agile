package com.mocadev.taskagile.domain.application.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-16
 **/
@Getter
@AllArgsConstructor
public class RegistrationCommand {

	private final String username;
	private final String emailAddress;
	private final String password;

}
