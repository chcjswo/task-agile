package com.mocadev.taskagile.domain.common.mail;

import org.springframework.stereotype.Component;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-17
 **/
@Component
public class DefaultMailManager implements MailManager  {

	@Override
	public void send(String emailAddress, String subject, String template,
					 MessageVariable... variables) {

	}

}
