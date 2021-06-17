package com.mocadev.taskagile.domain.common.model;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-18
 **/
public abstract class AbstractBaseEntity {

	public abstract boolean equals(Object obj);
	public abstract int hashCode();
	public abstract String toString();

}
