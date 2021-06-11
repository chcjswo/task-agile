package com.mocadev.taskagile.web.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-06-12
 **/
@Controller
public class MainController {

	@GetMapping(value = {"/", "/login"})
	public String entry() {
		return "index";
	}

}
