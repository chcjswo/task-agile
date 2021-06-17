package com.mocadev.taskagile.domain.model.user.events;

import com.mocadev.taskagile.domain.common.event.DomainEvent;
import com.mocadev.taskagile.domain.model.user.User;
import org.springframework.util.Assert;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-17
 **/
public class UserRegisteredEvent extends DomainEvent {
	private User user;

	public UserRegisteredEvent(User user) {
		super(user);
		Assert.notNull(user, "Parameter `user` must not be null");
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserRegisteredEvent that = (UserRegisteredEvent) o;
		return that.user.equals(this.user);
	}

	public int hashCode() {
		return this.user.hashCode();
	}

	public String toString() {
		return "UserRegisteredEvent{" +
			"user='" + user + '\'' +
			"timestamp='" + getTimestamp() + '\'' +
			'}';
	}

}
