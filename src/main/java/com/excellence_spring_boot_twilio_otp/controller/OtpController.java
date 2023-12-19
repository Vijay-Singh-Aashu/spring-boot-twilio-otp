package com.excellence_spring_boot_twilio_otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excellence_spring_boot_twilio_otp.dto.OtpRequest;
import com.excellence_spring_boot_twilio_otp.dto.OtpResponseDto;
import com.excellence_spring_boot_twilio_otp.dto.OtpValidationRequest;
import com.excellence_spring_boot_twilio_otp.service.SmsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/otp")
@Slf4j
public class OtpController {

	@Autowired
	private SmsService smsService;

	@GetMapping("/process")
	public String processSMS() {
		return "SMS sent";
	}

	@PostMapping("/send-otp")
	public OtpResponseDto sendOtp(@RequestBody OtpRequest otpRequest) {
		log.info("inside sendOtp :: " + otpRequest.getUsername());
		return smsService.sendSMS(otpRequest);
	}

	@PostMapping("/validate-otp")
	public String validateOtp(@RequestBody OtpValidationRequest otpValidationRequest) {
		log.info("inside validateOtp :: " + otpValidationRequest.getUsername() + " "
				+ otpValidationRequest.getOtpNumber());
		return smsService.validateOtp(otpValidationRequest);
	}

}
