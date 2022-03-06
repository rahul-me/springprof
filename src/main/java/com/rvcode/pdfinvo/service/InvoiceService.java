package com.rvcode.pdfinvo.service;

import com.rvcode.pdfinvo.model.Invoice;
import com.rvcode.pdfinvo.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceService {
	
    private UserService userService;
    
    
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
    
    @Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

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
