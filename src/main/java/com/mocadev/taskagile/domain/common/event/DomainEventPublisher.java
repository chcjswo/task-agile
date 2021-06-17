package com.mocadev.taskagile.domain.common.event;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-17
 **/
public interface DomainEventPublisher {
	void publish(DomainEvent event);
}
