package com.mocadev.taskagile.domain.common.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-17
 **/
public abstract class DomainEvent extends ApplicationEvent {

	public DomainEvent(Object source) {
		super(source);
	}

	public long occurredAt() {
		return getTimestamp();
	}

}
