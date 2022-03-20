package com.rvcode.pdfinvo.service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.rvcode.pdfinvo.model.Invoice;
import com.rvcode.pdfinvo.model.User;

@Component
public class InvoiceService {

	private UserService userService;
	private final String cdnUrl;

	public InvoiceService(UserService userService, @Value("${cdn.url}") String cdnUrl) {
		this.userService = userService;
		this.cdnUrl = cdnUrl;
	}

	@PostConstruct
	public void init() {
		System.out.println("Fetching PDF template from S3..");
		// To download from S3 and save locally
	}

	@PreDestroy
	public void shutdown() {
		System.out.println("Deleting downloaded templates");
		// TODO actual deletion of downloaded templates
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	List<Invoice> invoices = new CopyOnWriteArrayList<>();

	public List<Invoice> findAll() {
		return invoices;
	}

	public Invoice create(String userId, Integer amount) {

		User user = userService.findById(userId);
		if (user == null) {
			throw new IllegalStateException();
		}

		Invoice inv = new Invoice(userId, amount, cdnUrl + "/images/default/sample.pdf");
		invoices.add(inv);
		return inv;
	}

	public void throwException() {
		throw new ConstraintViolationException("some string", Collections.EMPTY_SET);
	}
}
