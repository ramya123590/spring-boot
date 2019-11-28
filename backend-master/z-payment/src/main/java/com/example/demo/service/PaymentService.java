package com.example.demo.service;

import com.example.demo.entity.PaymentCallback;
import com.example.demo.entity.PaymentDetail;

public interface PaymentService {
	 public PaymentDetail proceedPayment(PaymentDetail paymentDetail);
	 public String payuCallback(PaymentCallback paymentResponse);
	}
