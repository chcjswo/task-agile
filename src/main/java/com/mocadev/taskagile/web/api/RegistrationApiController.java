package com.mocadev.taskagile.web.api;

import com.mocadev.taskagile.web.payload.RegistrationPayload;
import com.mocadev.taskagile.web.results.ApiResult;
import com.mocadev.taskagile.web.results.Result;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-16
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RegistrationApiController {

	private final UserService service;

	@PostMapping("/registrations")
	public ResponseEntity<ApiResult> register(@Valid @RequestBody RegistrationPayload payload) {
		try {
			service.register(payload.toCommand());
			return Result.created();
		} catch (RegistrationException e) {
			return Result.fail("error");
		}
	}


}
