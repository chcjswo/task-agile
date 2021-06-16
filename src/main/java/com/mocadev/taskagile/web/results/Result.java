package com.mocadev.taskagile.web.results;

import org.springframework.http.ResponseEntity;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-17
 **/
public class Result {

	private Result() {
	}

	public static ResponseEntity<ApiResult> created() {
		return ResponseEntity.status(201).build();
	}

	public static ResponseEntity<ApiResult> fail(String message) {
		return ResponseEntity.badRequest().body(ApiResult.message(message));
	}

}
