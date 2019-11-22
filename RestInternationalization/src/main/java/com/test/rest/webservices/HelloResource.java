package com.test.rest.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloWorld() {
		return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
	}

}
