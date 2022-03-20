package com.rvcode.pdfinvo.web;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rvcode.pdfinvo.model.Invoice;
import com.rvcode.pdfinvo.service.InvoiceService;

@RestController // This class can accept HTTP requests.
@Validated
public class InvoicesController {

	private final InvoiceService invoiceService;

	public InvoicesController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@GetMapping("/invoices")
	public List<Invoice> index() {
		return invoiceService.findAll();
	}

	@PostMapping("/invoices")
	public Invoice createInvoice(@RequestParam("user_id") @NotBlank String userId,
			@RequestParam("amount") @Min(10) @Max(50) Integer amount) {
		return invoiceService.create(userId, amount);
	}

	@GetMapping("/throwex")
	public void throwExceptionInService() {
		invoiceService.throwException();
	}
}
