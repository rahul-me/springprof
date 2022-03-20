package com.rvcode.pdfinvo.web;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rvcode.pdfinvo.dto.InvoiceDto;
import com.rvcode.pdfinvo.model.Invoice;
import com.rvcode.pdfinvo.service.InvoiceService;

@RestController //This class can accept HTTP requests.
@Validated
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
	public Invoice createInvoice(@RequestParam("user_id") @NotBlank String userId, @RequestParam("amount") @Min(10) @Max(50) Integer amount) {
		return invoiceService.create(userId	, amount);
	}
}
