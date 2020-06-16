package com.proj.captcha.service;

import com.proj.captcha.controller.dto.CaptchaDTO;

public interface ICaptchaService {

	public CaptchaDTO generateCaptch();

	public String validateCaptcha(int id, String captcha);

	public CaptchaDTO saveCaptcha(String code);

}
