package com.mocadev.taskagile.domain.common.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-17
 **/
@Component
@RequiredArgsConstructor
public class DefaultDomainEventPublisher implements DomainEventPublisher {

	private final ApplicationEventPublisher eventPublisher;

	@Override
	public void publish(DomainEvent event) {
		eventPublisher.publishEvent(event);
	}

}
