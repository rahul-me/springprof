package com.rvcode.pdfinvo.service;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DummyInvoiceLoaderService {
	private final InvoiceService invoiceService;
	
	public DummyInvoiceLoaderService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	@PostConstruct
	public void setup() {
		System.out.println("creating dev invoices..");
		invoiceService.create("id1", 450);
		invoiceService.create("id2", 540);
	}
}
