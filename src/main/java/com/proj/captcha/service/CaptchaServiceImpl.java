package com.proj.captcha.service;

import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.captcha.controller.dto.CaptchaDTO;
import com.proj.captcha.domain.CaptchaEntity;
import com.proj.captcha.exception.InvalidDataException;
import com.proj.captcha.repository.CaptchaRepository;

@Service
public class CaptchaServiceImpl implements ICaptchaService {

	@Autowired
	private CaptchaRepository repository;
	private static Logger logger = LoggerFactory.getLogger(CaptchaServiceImpl.class);
	private static final String code = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	@Override
	public CaptchaDTO generateCaptch() {
		int length = 8;
		StringBuilder builder = new StringBuilder();
		while (length > 0) {
			Random random = new Random();
			int index = random.nextInt(61);
			char c = code.charAt(index);
			builder.append(c);
			length--;
		}
		logger.info("Created Captcha : " + builder.toString());
		CaptchaDTO dto = saveCaptcha(builder.toString());
		return dto;
	}

	@Override
	public String validateCaptcha(int id, String captcha) {
		CaptchaEntity captchaEntity = repository.findByIdAndCode(id, captcha);
		if (captchaEntity == null || !captchaEntity.getCode().equals(captcha)) {
			throw new InvalidDataException("Invalid captcha or id.");
		}
		return captcha;
	}

	@Override
	public CaptchaDTO saveCaptcha(String code) {
		CaptchaEntity entity = new CaptchaEntity();
		entity.setCode(code);
		entity.setCreatedDate(new Date());
		CaptchaEntity cap = repository.save(entity);
		CaptchaDTO dto = new CaptchaDTO();
		BeanUtils.copyProperties(cap, dto);
		return dto;
	}

}
