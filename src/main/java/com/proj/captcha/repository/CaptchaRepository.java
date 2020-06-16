package com.proj.captcha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.captcha.domain.CaptchaEntity;

@Repository
public interface CaptchaRepository extends JpaRepository<CaptchaEntity, Integer> {

	public CaptchaEntity findByIdAndCode(int id, String code);

}
