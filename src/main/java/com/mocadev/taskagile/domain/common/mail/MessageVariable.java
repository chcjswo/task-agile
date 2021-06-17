package com.mocadev.taskagile.domain.common.mail;

import java.util.Objects;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-17
 **/
public class MessageVariable {

	private final String key;
	private final Object value;

	private MessageVariable(String key, Object value) {
		this.key = key;
		this.value = value;
	}

	public static MessageVariable from(String key, Object value) {
		return new MessageVariable(key, value);
	}

	public String getKey() {
		return key;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof MessageVariable)) {
			return false;
		}
		MessageVariable that = (MessageVariable) o;
		return Objects.equals(key, that.key) &&
			Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, value);
	}

	@Override
	public String toString() {
		return "MessageVariable{" +
			"key='" + key + '\'' +
			", value=" + value +
			'}';
	}

}
