package com.rvcode.pdfinvo.service;

import com.rvcode.pdfinvo.model.Invoice;
import com.rvcode.pdfinvo.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceService {
	
	@Autowired
    private UserService userService;

    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public List<Invoice> findAll(){
        return invoices;
    }

    public Invoice create(String userId, Integer amount){
        User user = userService.findById(userId);
        if(user == null){
            throw new IllegalStateException();
        }

        Invoice inv = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
        invoices.add(inv);
        return inv;
    }
}
