package com.mocadev.taskagile.domain.application.impl;

import com.mocadev.taskagile.domain.application.commands.RegistrationCommand;
import com.mocadev.taskagile.domain.common.event.DomainEventPublisher;
import com.mocadev.taskagile.domain.common.mail.MailManager;
import com.mocadev.taskagile.domain.common.mail.MessageVariable;
import com.mocadev.taskagile.domain.model.user.RegistrationException;
import com.mocadev.taskagile.domain.model.user.RegistrationManagement;
import com.mocadev.taskagile.domain.model.user.User;
import com.mocadev.taskagile.domain.model.user.events.UserRegisteredEvent;
import com.mocadev.taskagile.web.api.UserService;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-18
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final RegistrationManagement registrationManagement;
	private final DomainEventPublisher domainEventPublisher;
	private final MailManager mailManager;

	@Override
	public void register(RegistrationCommand command) throws RegistrationException {
		Assert.notNull(command, "Parameter `command` must not be null");
		User newUser = registrationManagement.register(
			command.getUsername(),
			command.getEmailAddress(),
			command.getPassword());

		sendWelcomeMessage(newUser);
		domainEventPublisher.publish(new UserRegisteredEvent(newUser));
	}

	private void sendWelcomeMessage(User user) {
		mailManager.send(
			user.getEmailAddress(),
			"Welcome to TaskAgile",
			"welcome.ftl",
			MessageVariable.from("user", user)
		);
	}

}
