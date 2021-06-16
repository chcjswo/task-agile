package com.mocadev.taskagile.web.payload;

import com.mocadev.taskagile.web.api.RegistrationCommand;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-16
 **/
@Data
public class RegistrationPayload {

	@Size(min = 2, max = 50, message = "Username must be between 2 and 50 characters")
	@NotNull
	private String username;

	@Email(message = "이메일 형식 틀림")
	@Size(max = 100, message = "100 characters")
	@NotNull
	private String emailAddress;

	@Size(min = 6, max = 30, message = "6 ~ 30 사이로 해")
	@NotNull
	private String password;

	public RegistrationCommand toCommand() {
		return new RegistrationCommand(this.username, this.emailAddress, this.password);
	}

}
