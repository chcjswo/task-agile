package com.mocadev.taskagile.domain.common.security;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-18
 **/
public interface PasswordEncryptor {
	String encrypt(String rawPassword);
}
