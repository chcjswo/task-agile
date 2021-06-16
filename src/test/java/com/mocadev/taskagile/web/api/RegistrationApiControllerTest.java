package com.mocadev.taskagile.web.api;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mocadev.taskagile.utils.JsonUtils;
import com.mocadev.taskagile.web.payload.RegistrationPayload;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-16
 **/
@ExtendWith(SpringExtension.class)
@WebMvcTest(RegistrationApiController.class)
class RegistrationApiControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService serviceMock;

	@Test
	void register_blankPayload_shouldFailAndReturn400() throws Exception {
		mvc.perform(post("/api/registration"))
			.andExpect(status().is(400));
	}

	@Test
	void register_existUsername_shouldFailAndReturn400() throws Exception {
		RegistrationPayload payload = new RegistrationPayload();
		payload.setUsername("tony");
		payload.setEmailAddress("test@test.com");
		payload.setPassword("1111");

//		doThrow(UsernameExistsException.class)
//			.when(serviceMock)
//			.register(payload.toCommand());

		mvc.perform(
			post("/api/registrations")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson(payload)))
			.andExpect(status().is(400))
			.andExpect(jsonPath("$.message").value("Username already exists"));
	}

	@Test
	public void register_existedEmailAddress_shouldFailAndReturn400() throws Exception {
		RegistrationPayload payload = new RegistrationPayload();
		payload.setUsername("test");
		payload.setEmailAddress("exist@taskagile.com");
		payload.setPassword("MyPassword!");

//		doThrow(EmailAddressExistsException.class)
//			.when(serviceMock)
//			.register(payload.toCommand());

		mvc.perform(
			post("/api/registrations")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson(payload)))
			.andExpect(status().is(400))
			.andExpect(jsonPath("$.message").value("Email address already exists"));
	}

	@Test
	public void register_validPayload_shouldSucceedAndReturn201() throws Exception {
		RegistrationPayload payload = new RegistrationPayload();
		payload.setUsername("sunny");
		payload.setEmailAddress("sunny@taskagile.com");
		payload.setPassword("MyPassword!");

		doNothing().when(serviceMock)
			.register(payload.toCommand());

		mvc.perform(
			post("/api/registrations")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson(payload)))
			.andExpect(status().is(201));
	}

}
