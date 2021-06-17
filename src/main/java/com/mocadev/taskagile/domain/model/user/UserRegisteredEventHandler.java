package com.mocadev.taskagile.domain.model.user;

import com.mocadev.taskagile.domain.model.user.events.UserRegisteredEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-17
 **/
@Slf4j
@Component
public class UserRegisteredEventHandler {

	@EventListener(UserRegisteredEvent.class)
	public void handleEvent(UserRegisteredEvent event) {
		log.debug("Handling `{}` registration event", event.getUser().getEmailAddress());
	}

}
