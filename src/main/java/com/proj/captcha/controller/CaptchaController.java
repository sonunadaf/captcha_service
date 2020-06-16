package com.proj.captcha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.captcha.controller.dto.CaptchaDTO;
import com.proj.captcha.service.ICaptchaService;

@RestController
public class CaptchaController {

	@Autowired
	private ICaptchaService captchaService;
	private static Logger logger = LoggerFactory.getLogger(CaptchaController.class);

	@PostMapping("/generate")
	public ResponseEntity<CaptchaDTO> generateCaptch() {
		CaptchaDTO captchaDTO = captchaService.generateCaptch();
		return new ResponseEntity<CaptchaDTO>(captchaDTO, HttpStatus.OK);
	}

	@GetMapping("/validate/{id}/{code}")
	public ResponseEntity<String> validateCaptcha(@PathVariable int id, @PathVariable String code) {
		logger.info("id : " + id + ", code : " + code);
		captchaService.validateCaptcha(id, code);
		return new ResponseEntity<String>("Valid captcha.", HttpStatus.OK);
	}

}
