package com.mocadev.taskagile.domain.common.mail;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-17
 **/
public interface MailManager {
	void send(String emailAddress, String subject, String template, MessageVariable... variables);
}
