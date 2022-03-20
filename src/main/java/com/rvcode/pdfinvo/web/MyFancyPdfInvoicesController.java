package com.rvcode.pdfinvo.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rvcode.pdfinvo.dto.InvoiceDto;
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
	
	@PostMapping("/invoices")
	public Invoice createInvoice(@RequestBody @Valid InvoiceDto invoice) {
		return invoiceService.create(invoice.getUserId(), invoice.getAmount());
	}
}
