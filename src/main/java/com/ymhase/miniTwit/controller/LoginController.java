package com.ymhase.miniTwit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymhase.miniTwit.dto.LoginDto;
import com.ymhase.miniTwit.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	/*
	 * @RequestMapping(method = RequestMethod.POST, value = "/login") public void
	 * login(@RequestBody LoginDto loginDto) {
	 * 
	 * System.out.println(loginDto.getUsername()); loginService.login(loginDto);
	 * 
	 * }
	 * 
	 * @RequestMapping(method = RequestMethod.GET, value = "/getname") public
	 * List<String> getName() {
	 * 
	 * return login.getuser();
	 * 
	 * }
	 * 
	 * @RequestMapping(method = RequestMethod.POST, value = "/userlist") public
	 * List<UserModelMapper> userList(@RequestBody LoginDto loginDto) {
	 * 
	 * System.out.println(loginDto.getUsername()); return
	 * login.getUserList(loginDto.getUsername(), loginDto.getPassword());
	 * 
	 * }
	 */

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String login(@RequestBody LoginDto loginDto) {

		if (loginService.login(loginDto)) {
			return "is there";

		} else {
			return "not there";
		}

	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/forgotusername/{email:.+}")
	public String login(@PathVariable String email) {

		return loginService.forgotUsername(email);

	}

}
