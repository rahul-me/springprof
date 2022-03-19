package com.rvcode.pdfinvo.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvcode.pdfinvo.model.Invoice;
import com.rvcode.pdfinvo.service.InvoiceService;

@RestController //This class can accept HTTP requests.
public class MyFancyPdfInvoicesController {
	
	private final InvoiceService invoiceService;
	
	public MyFancyPdfInvoicesController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	@GetMapping("/invoices")
	public List<Invoice> index() {
		return invoiceService.findAll();
	}
	
	@PostMapping("/invoices/{userId}/{amount}")
	public Invoice createInvoice(@PathVariable String userId, @PathVariable Integer amount) {
		return invoiceService.create(userId, amount);
	}
}
