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

/*
 * Your controller class is a normal Java class, that does not need to implement 
 * any specific interfaces or extend from another class.
 * 
 * You do however need to mark it with the @Controller annotation, so that Spring’s 
 * @ComponentScan can find it and make Spring MVC understand: This class can accept HTTP requests.
 * 
 * @ResponseBody tells Spring, that you want to write JSON or XML or plain text directly 
 * to the HttpServletOutputstream, but without going through an HTML templating framework - which Spring 
 * would assume by default if you didn’t annotate your method with @ResponseBody. 
 * You will learn more about rendering HTML in the next module, so more on that later on.
 */

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
